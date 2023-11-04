package com.chaverma.api.dataSender;


import com.chaverma.api.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
abstract public class DataGetSender<Returned> extends DataSender<Returned> {

    public DataGetSender(String currentUrl) {
        super(currentUrl);
    }

    protected ApiResponse<Returned> send(Object params) {
        log.info("Send GET-request to: {}", url);
        ParameterizedTypeReference<ApiResponse<Returned>> responseType = new ParameterizedTypeReference<>() {};
        RestTemplate restTemplate = buildRestTemplate(CONST_TIMEOUT);
        try {
            if (params instanceof Map)
                responseEntity = restTemplate.exchange(
                        url, HttpMethod.GET, null, responseType, (Map<String, ?>) params);
            else
                responseEntity = restTemplate.exchange(
                        url,  HttpMethod.GET, null, responseType, params
                );



            this.apiResponse = responseEntity.getBody();
            log.info("Successfully GET-request to: {}", url);
        } catch (HttpClientErrorException clientError) {
            HttpStatusCode httpStatus = clientError.getStatusCode();
            String errorMessage = clientError.getResponseBodyAsString();
            this.apiResponse.setHttpStatus(httpStatus);
            this.apiResponse.setMessage(errorMessage);
            log.error("Error GET-request to: {} with status: {} and error: {}", url, httpStatus, errorMessage);
        }
        return this.apiResponse;
    }

    abstract public ApiResponse<Returned> execute(Object params);


}
