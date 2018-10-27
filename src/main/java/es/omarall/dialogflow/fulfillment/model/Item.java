package es.omarall.dialogflow.fulfillment.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class Item {
    /**
     * Required. Additional information about this option.
     */
    private SelectItemInfo info;

    /**
     * Required. The title of the list item.
     */
    private String title;

    /**
     * Optional. The main text describing the item.
     */
    private String description;

    /**
     * The image to display
     */
    private Image image;

}
