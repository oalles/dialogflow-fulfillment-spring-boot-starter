package es.omarall.dialogflow.fulfillment.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * The simple response message containing speech or text.
 */
@Setter
@Getter
@Builder
public class SimpleResponse {

    /**
     * One of textToSpeech or ssml must be provided. The plain text of the speech output. Mutually exclusive with ssml.
     */
    private String textToSpeech;

    /**
     * One of textToSpeech or ssml must be provided. Structured spoken response to the user in the SSML format. Mutually exclusive with textToSpeech.
     */
    private String ssml;

    /**
     * Optional. The text to display.
     */
    private String displayText;
}
