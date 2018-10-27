package es.omarall.dialogflow.fulfillment.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * The card response message.
 */
@Setter
@Getter
@Builder
public class Card {

    private String title;
    private String subtitle;

    /**
     * Optional. The public URI to an image file for the card.
     */
    private String imageUri;

    private List<Button> buttons;
}
