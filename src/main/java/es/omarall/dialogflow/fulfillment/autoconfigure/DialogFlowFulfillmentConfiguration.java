package es.omarall.dialogflow.fulfillment.autoconfigure;

import com.google.gson.Gson;
import es.omarall.dialogflow.fulfillment.annotations.IntentHandlerBeanPostProcessor;
import es.omarall.dialogflow.fulfillment.annotations.IntentHandlerInvoker;
import es.omarall.dialogflow.fulfillment.controllers.FulfillmentController;
import es.omarall.dialogflow.fulfillment.utils.DialogflowFulfillmentUtils;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Role;
import org.springframework.http.converter.json.GsonHttpMessageConverter;

@Configuration
@Role(BeanDefinition.ROLE_INFRASTRUCTURE)
public class DialogFlowFulfillmentConfiguration {

    @Bean(name = DialogflowFulfillmentUtils.DF_FULFILLMENT_PROCESSOR_BEAN_NAME)
    @Role(BeanDefinition.ROLE_INFRASTRUCTURE)
    public IntentHandlerBeanPostProcessor intentHandlerBeanPostProcessor() {
        return new IntentHandlerBeanPostProcessor();
    }

    @Bean
    public GsonHttpMessageConverter gsonHttpMessageConverter(Gson gson) {
        GsonHttpMessageConverter converter = new GsonHttpMessageConverter();
        converter.setGson(gson);
        return converter;
    }

    @Bean
    public IntentHandlerInvoker intentHandlerInvoker() {
        return new IntentHandlerInvoker();
    }

    @Bean
    public FulfillmentController controller(IntentHandlerInvoker intentHandlerInvoker) {
        return new FulfillmentController(intentHandlerInvoker);
    }


}
