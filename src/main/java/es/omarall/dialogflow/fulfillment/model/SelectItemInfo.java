package es.omarall.dialogflow.fulfillment.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Builder
/**
 * Additional info about the select item for when it is triggered in a dialog.
 */
public class SelectItemInfo {
    /**
     * Required. A unique key that will be sent back to the agent if this response is given.
     */
    private String key;

    /**
     * A list of synonyms that can also be used to trigger this item in dialog.
     */
    private List<String> synonyms;
}
