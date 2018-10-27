package es.omarall.dialogflow.fulfillment.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by omar on 19/05/17.
 */
@Getter
@Setter
public class FieldErrorResource {
    private String resource;
    private String field;
    private String code;
    private String message;

    @Override
    public String toString() {
        return "FieldErrorResource{" +
                "resource='" + resource + '\'' +
                ", field='" + field + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
