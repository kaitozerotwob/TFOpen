package org.hign.platform.u20221a322.shared.infrastructure.swf.exception.handler;

import org.hign.platform.u20221a322.shared.interfaces.rest.resources.MessageResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.io.IOException;

/**
 * @summary
 * <p>
 *     This class is responsible for handling exceptions that are not handled by the application.
 *     Returns a message with the exception message with a bad request status.
 * </p>
 * @author Alex Avila Asto
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<MessageResource> handleRuntimeException(RuntimeException e) {
        LOGGER.error("Debugging error", e);
        return ResponseEntity.badRequest().body(new MessageResource(e.getMessage()));
    }

    @ExceptionHandler({IOException.class})
    public ResponseEntity<MessageResource> handleIOException(IOException e) {
        LOGGER.error("Debugging error", e);
        return ResponseEntity.badRequest().body(new MessageResource(e.getLocalizedMessage()));
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<MessageResource> handleIllegalArgumentException(IllegalArgumentException e) {
        LOGGER.error("Debugging error", e);
        return ResponseEntity.badRequest().body(new MessageResource(e.getMessage()));
    }

    @ExceptionHandler({MissingServletRequestPartException.class})
    public ResponseEntity<MessageResource> handleMissingServletRequestPartException(MissingServletRequestPartException e) {
        LOGGER.error("Debugging error", e);
        return ResponseEntity.badRequest().body(new MessageResource(e.getMessage()));
    }

}