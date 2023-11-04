package com.chaverma.exception;

public class RestRequestFailedException extends RuntimeException {
    public RestRequestFailedException(String message, Throwable cause) {
        super(message, cause);
    }
}
