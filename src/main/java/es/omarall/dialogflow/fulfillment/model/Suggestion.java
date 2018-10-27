package es.omarall.dialogflow.fulfillment.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The suggestion CHIP message that the user can tap to quickly post a reply to the conversation.
 */
@Setter
@Getter
@Builder
public class Suggestion {
    /**
     * The text shown the in the suggestion chip.
     */
    private String title;
}
