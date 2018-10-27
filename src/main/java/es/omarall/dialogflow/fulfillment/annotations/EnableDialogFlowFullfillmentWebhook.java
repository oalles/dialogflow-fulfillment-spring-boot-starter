package es.omarall.dialogflow.fulfillment.annotations;

import es.omarall.dialogflow.fulfillment.autoconfigure.DialogFlowFulfillmentConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;


@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(DialogFlowFulfillmentConfiguration.class)
public @interface EnableDialogFlowFullfillmentWebhook {
}