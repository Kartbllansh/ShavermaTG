package com.chaverma.response;

import com.chaverma.api.ApiResponse;
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
    public static <T> ResponseEntity<ApiResponse<T>> responseBuilder(String message, HttpStatus httpStatus, T responseData) {

        ApiResponse<T> response = new ApiResponse<>(responseData, message, httpStatus);
        log.info("Successfully response with message: {} and status: {}", message, httpStatus);

        return new ResponseEntity<>(response, httpStatus);
    }
}
