package es.omarall.dialogflow.fulfillment.autoconfigure;

import es.omarall.dialogflow.fulfillment.properties.FulfillmentProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(FulfillmentProperties.class)
public class FulfillmentAutoConfiguration {
}
