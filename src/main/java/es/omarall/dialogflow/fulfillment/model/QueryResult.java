package es.omarall.dialogflow.fulfillment.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
public class QueryResult {
    private String queryText;
    private Map<String, String> parameters;
    private boolean allRequiredParamsPresent;
    private String fulfillmentText;
    private List<FulfillmentMessage> fulfillmentMessages;
    private List<OutputContext> outputContexts;
    private Intent intent;
    private float intentDetectionConfidence;
    private String languageCode;
    private Object diagnosticInfo;
}
