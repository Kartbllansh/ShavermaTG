package com.chaverma.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.Map;

/**
 * The type Response handler.
 */
@Slf4j
public class ResponseHandler {
    /**
     * Response builder response entity.
     *
     * @param message      the message
     * @param httpStatus   the http status
     * @param responseData the response data
     * @return the response entity
     */
    public static ResponseEntity<Object> responseBuilder(String message, HttpStatus httpStatus, Object responseData) {
        Map<String, Object> response = new HashMap<>();
        response.put("data", responseData);
        response.put("message", message);
        response.put("httpStatus", httpStatus.value());

        log.info("Successfully response with message: {} and status: {}", message, httpStatus);

        return new ResponseEntity<>(response, httpStatus);
    }
}
