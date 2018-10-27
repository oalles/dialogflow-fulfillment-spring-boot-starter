package es.omarall.dialogflow.fulfillment.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
public class FulfillmentResponse {

    /**
     * The text to be pronounced to the user or shown on the screen.
     */
    private String fulfillmentText;

    /**
     * The collection of rich messages to present to the user.
     */
    private List<FulfillmentMessage> fulfillmentMessages;

    /**
     * If the query was fulfilled by a webhook call, this field is set to the value of the source field returned in the webhook response.
     */
    private String source;

    /**
     * If the query was fulfilled by a webhook call, this field is set to the value of the payload field returned in the webhook response.
     */
    private Payload payload;

    /**
     * The collection of output contexts. If applicable, outputContexts.parameters contains entries with name <parameter name>.original containing the original parameter values before the query.
     */
    private List<OutputContext> outputContexts;


    private FollowupEventInput followupEventInput;
}
