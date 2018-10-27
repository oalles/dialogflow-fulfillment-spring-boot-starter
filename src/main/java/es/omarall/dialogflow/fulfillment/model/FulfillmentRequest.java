package es.omarall.dialogflow.fulfillment.model;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@Setter
@Getter
@ToString
public class FulfillmentRequest {
    private UUID responseId;
    private String session;
    private QueryResult queryResult;
    private OriginalDetectIntentRequest originalDetectIntentRequest;
 }
