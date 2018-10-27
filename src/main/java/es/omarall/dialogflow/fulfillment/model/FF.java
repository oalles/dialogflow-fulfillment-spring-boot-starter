package es.omarall.dialogflow.fulfillment.model;

import es.omarall.dialogflow.fulfillment.enums.Platform;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class FF {

    private final FulfillmentRequest request;
    private final FulfillmentResponse response;

    public FF(FulfillmentRequest request) {
        this.request = request;
        this.response = FulfillmentResponse.builder()
                .fulfillmentText(request.getQueryResult().getFulfillmentText())
                .outputContexts(request.getQueryResult().getOutputContexts())
                .fulfillmentMessages(request.getQueryResult().getFulfillmentMessages())
                .source("wh-source")
                .build();

    }

    public void onlyOneContextAllowed(final String contextName) {
        this.response.getOutputContexts().stream().filter(outputContext -> {
            return !outputContext.getName().toLowerCase().contains((contextName.toLowerCase()));
        }).forEach(outputContext -> {
            outputContext.setLifespanCount(0);
        });
    }

    public void setFulfillmentMessages(List<FulfillmentMessage> fulfillmentMessages) {
        this.getResponse().setFulfillmentMessages(fulfillmentMessages);
    }

}
