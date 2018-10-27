package es.omarall.dialogflow.fulfillment.controllers;

import es.omarall.dialogflow.fulfillment.annotations.IntentHandlerInvoker;
import es.omarall.dialogflow.fulfillment.model.ErrorInfo;
import es.omarall.dialogflow.fulfillment.model.FF;
import es.omarall.dialogflow.fulfillment.model.FulfillmentRequest;
import es.omarall.dialogflow.fulfillment.model.FulfillmentResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import static org.springframework.http.ResponseEntity.status;


@RestController
@Slf4j
public class FulfillmentController {

    private IntentHandlerInvoker intentHandlerInvoker;

    public FulfillmentController(IntentHandlerInvoker intentHandlerInvoker) {
        this.intentHandlerInvoker = intentHandlerInvoker;
    }

    @PostMapping(path = "/df", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<FulfillmentResponse> dialogFlowEndpoint(@Valid @RequestBody FulfillmentRequest req) {

        FF ff = new FF(req);

        this.intentHandlerInvoker.fulfill(req.getQueryResult().getIntent().getDisplayName(),
                ff);
        return status(HttpStatus.OK)
                .body(ff.getResponse());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(code = HttpStatus.INTERNAL_SERVER_ERROR, reason = "Error en el servidor")
    public ErrorInfo handleThrowable(HttpServletRequest req, Throwable t) {

        // TODO: Mejorar esto

        log.error(t.getLocalizedMessage());

        ErrorInfo error = new ErrorInfo();
        error.setPath(req.getRequestURL().toString());
        error.setMessage("Error en el servidor");

        log.error("Error indeterminado en el servidor - 5xx: {}", error.toString());
        return error;
    }
}

