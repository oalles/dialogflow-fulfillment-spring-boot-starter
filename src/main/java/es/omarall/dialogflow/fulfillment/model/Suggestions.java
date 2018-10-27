package es.omarall.dialogflow.fulfillment.model;

import java.util.List;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Suggestions {
    private List<Suggestion> suggestions;
}
