package es.omarall.dialogflow.fulfillment.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Setter
@Getter
@Builder
public class FollowupEventInput {
    private String name;
    private String languageCode; // Puede ser locale
    private Map<String, String> parameters;
}
