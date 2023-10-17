package com.chaverma.telegram.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
public class ResponseError {
    private String errorMessage;
    private HttpStatus httpStatus;
    private boolean hasError;

}