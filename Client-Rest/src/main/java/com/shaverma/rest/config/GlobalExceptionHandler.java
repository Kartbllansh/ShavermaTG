package com.shaverma.rest.config;

import com.chaverma.api.ApiResponse;
import com.chaverma.dto.ErrorDTO;
import com.chaverma.response.ResponseHandler;
import com.shaverma.rest.error.ApiException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<ErrorDTO>> handleApiException(ApiException ex){
        ErrorDTO errorDTO = new ErrorDTO(ex.getMessage(), ex.getCode());
        return ResponseHandler.responseBuilder(ex.getMessage(), ex.getHttpStatus(), errorDTO);
    }
}
