package es.omarall.dialogflow.fulfillment.annotations;

import es.omarall.dialogflow.fulfillment.model.FF;
import es.omarall.dialogflow.fulfillment.model.FulfillmentRequest;
import es.omarall.dialogflow.fulfillment.model.FulfillmentResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.MethodIntrospector;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.util.Assert;

import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class IntentHandlerBeanPostProcessor implements DestructionAwareBeanPostProcessor,  ApplicationContextAware, DisposableBean {

    protected final Log logger = LogFactory.getLog(getClass());

    private ApplicationContext applicationContext;

    private final Set<Class<?>> nonAnnotatedClasses =
            Collections.newSetFromMap(new ConcurrentHashMap<Class<?>, Boolean>(64));

    private IntentHandlerInvoker intentHandlerInvoker;

    @Override
    public void destroy() throws Exception {
        nonAnnotatedClasses.clear();
    }

    @Override
    public void postProcessBeforeDestruction(Object o, String s) throws BeansException {
        this.nonAnnotatedClasses.clear();
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
        this.intentHandlerInvoker = this.applicationContext.getBean(IntentHandlerInvoker.class);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class<?> targetClass = AopUtils.getTargetClass(bean);

        if (!this.nonAnnotatedClasses.contains(targetClass)) {
            Map<Method, IntentHandler> annotatedMethods = MethodIntrospector.selectMethods(targetClass,
                    new MethodIntrospector.MetadataLookup<IntentHandler>() {
                        @Override
                        public IntentHandler inspect(Method method) {
                            return AnnotatedElementUtils.getMergedAnnotation(
                                    method, IntentHandler.class);
                        }
                    });
            if (annotatedMethods.isEmpty()) {
                this.nonAnnotatedClasses.add(targetClass);
                if (logger.isTraceEnabled()) {
                    logger.trace("No @IntentHandler annotations found on bean class: " + bean.getClass());
                }
            } else {

                // Non-empty set of methods
                for (Map.Entry<Method, IntentHandler> entry : annotatedMethods.entrySet()) {
                    Method method = entry.getKey();
                    processIntentHandlers(entry.getValue(), method, bean);
                }
                if (logger.isDebugEnabled()) {
                    logger.debug(annotatedMethods.size() + " @IntentHandler methods processed on bean '" + beanName +
                            "': " + annotatedMethods);
                }
            }
        }
        return bean;
    }

    private void processIntentHandlers(IntentHandler intentHandler, Method method, Object bean) {

        Assert.isTrue(method.getParameterTypes().length == 1,
                "Only 1-arg methods may be annotated with @IntentHandler");

        Class<?> argType = method.getParameterTypes()[0];
        Assert.isTrue(argType.isAssignableFrom(FF.class),
                "Only methods with FF argument type may be annotated with @IntentHandler");

        Class<?> returnType = method.getReturnType();
        Assert.isTrue(returnType.isAssignableFrom(void.class),
                "Only methods with void return type may can be annotated with @IntentHandler");

        this.intentHandlerInvoker.addHandlerByIntentDisplayname(intentHandler.forIntentName(), method, bean);
    }

}
