package es.omarall.dialogflow.fulfillment.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class LinkOutSuggestion {
    /**
     * Required. The name of the app or site this chip is linking to.
     */
    private String destinationName;

    /**
     * Required. The URI of the app or site to open when the user taps the suggestion chip.
     */
    private String uri;
}
