package es.omarall.dialogflow.fulfillment.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "dialogflow-fulfillment")
@Getter
@Setter
public class FulfillmentProperties {
    private String path = "/";
}
