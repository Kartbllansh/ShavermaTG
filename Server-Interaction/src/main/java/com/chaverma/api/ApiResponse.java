package com.chaverma.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatusCode;

@Data
@NoArgsConstructor
public class ApiResponse<T> {
    private T data;
    private String message;
    private HttpStatusCode httpStatus;

    @JsonProperty("data")
    public void setData(T data) {
        this.data = data;
    }
}
