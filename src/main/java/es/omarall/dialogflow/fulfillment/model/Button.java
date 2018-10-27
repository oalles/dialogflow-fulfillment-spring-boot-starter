package es.omarall.dialogflow.fulfillment.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Button {

    /**
     * Optional. The text to show on the button.
     */
    private String text;

    /**
     * Optional. The text to send back to the Dialogflow API or a URI to open.
     */
    private String postback;
}
