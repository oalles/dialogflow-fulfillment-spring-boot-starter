package es.omarall.dialogflow.fulfillment.annotations;

import java.lang.annotation.*;

/**
 * Marks a method as the handler of a dialog intent in the deployed wh
 * */
@Documented
@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface IntentHandler {

    /**
     * The registered displayName that uniquely identifies the intent the annotated method is related to.
     * @return - the intent displayName in DialogFlow
     */
    String forIntentName() default "";
}
