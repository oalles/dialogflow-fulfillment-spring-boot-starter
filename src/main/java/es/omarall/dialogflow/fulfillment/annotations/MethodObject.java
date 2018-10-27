package es.omarall.dialogflow.fulfillment.annotations;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Method;

@Getter
@Setter
public class MethodObject {
    private Method method;
    private Object target;
}
