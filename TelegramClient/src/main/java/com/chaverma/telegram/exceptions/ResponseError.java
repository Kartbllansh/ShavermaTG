package com.chaverma.telegram.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
//TODO в какой пакет?
@Data
@AllArgsConstructor
public class ResponseError {
    private String errorMessage;
    private HttpStatus httpStatus;
    private boolean hasError;

}