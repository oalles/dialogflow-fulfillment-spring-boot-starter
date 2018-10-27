package es.omarall.dialogflow.fulfillment.model;


import es.omarall.dialogflow.fulfillment.enums.Platform;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


/**
 * Rich message to show the user. Corresponds to the Response field in the Dialogflow console.
 */
@Setter
@Getter
@Builder
public class FulfillmentMessage {

    /**
     * Optional. The platform that this message is intended for.
     */
    private Platform platform;

    /**
     * Only one of the following
     */
    private TextMessage text;
    private Image image;
    private QuickReplies quickReplies;
    private Card card;
    private SimpleResponses simpleResponses;
    private BasicCard basicCard;
    private Suggestions suggestions;
    private LinkOutSuggestion linkOutSuggestion;
    private ListSelect listSelect;
    private CarouselSelect carouselSelect;
}
