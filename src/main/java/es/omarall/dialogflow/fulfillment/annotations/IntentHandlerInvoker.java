package es.omarall.dialogflow.fulfillment.annotations;

import es.omarall.dialogflow.fulfillment.model.FF;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;
import java.util.HashMap;
import java.util.Map;

public class IntentHandlerInvoker {

    private Map<String, MethodObject> itemMethodMap = new HashMap<>();

    public void fulfill(String itemDisplayName, FF ff) {

        Assert.isTrue(!itemMethodMap.isEmpty(), "There is no method annotated to handle DialogFlow Fulfillments");

        try {
            final MethodObject mo = this.itemMethodMap.get(itemDisplayName);
            final Method method = mo.getMethod();
            ReflectionUtils.makeAccessible(method);
            method.invoke(mo.getTarget(), ff);
        } catch (InvocationTargetException ex) {
            throw new UndeclaredThrowableException(ex);
        } catch (IllegalAccessException ex) {
            throw new UndeclaredThrowableException(ex);
        }
    }

    public void addHandlerByIntentDisplayname(String intentDisplayName, Method method, Object target) {
        MethodObject mo = new MethodObject();
        mo.setMethod(method);
        mo.setTarget(target);
        this.itemMethodMap.put(intentDisplayName, mo);
    }
}

