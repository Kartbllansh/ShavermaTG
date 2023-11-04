package com.shaverma.rest.error;

import org.springframework.http.HttpStatus;

public enum ApiError {
    USER_NOT_FOUND("user not found", HttpStatus.NOT_FOUND);

    private final String message;
    private final HttpStatus httpStatus;

    ApiError(String message, HttpStatus httpStatus) {
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ApiException toException(){
        return new ApiException(message, httpStatus, name());
    }

}
