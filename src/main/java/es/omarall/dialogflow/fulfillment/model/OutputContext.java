package es.omarall.dialogflow.fulfillment.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Map;

@Setter
@Getter
@ToString
@Builder
public class OutputContext {
    private String name;
    private int lifespanCount;
    private Map<String, String> parameters;
}
