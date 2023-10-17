package com.chaverma.telegram.api.dataSender;

import com.chaverma.telegram.api.ApiResponse;
import com.chaverma.telegram.exceptions.RestRequestFailedException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Slf4j
abstract public class DataPostSender<Sent, Returned> extends DataSender<Returned> {

    public DataPostSender(String currentUrl) {
        super(currentUrl);
    }

    protected ApiResponse<Returned> send(Sent data, Object params) {
        return send(data, params, CONST_TIMEOUT);
    }


    protected ApiResponse<Returned> send(Sent data, Object params, int timeout) {
        log.info("Send POST-request to: {}", url);
        RestTemplate restTemplate = buildRestTemplate(timeout);
        HttpEntity<Sent> request = buildHttpEntity(data);
        ParameterizedTypeReference<ApiResponse<Returned>> responseType = new ParameterizedTypeReference<>() {
        };
        try {
            if(params instanceof Map) responseEntity = restTemplate.exchange(
                        url, HttpMethod.POST, request, responseType, (Map<String, ?>) params
            );
            else responseEntity = restTemplate.exchange(
                    url, HttpMethod.POST, request, responseType, params
            );
            apiResponse = responseEntity.getBody();
            log.info("Successfully POST-request to: {}", url);
        } catch (HttpClientErrorException clientError) {
            HttpStatusCode httpStatus = clientError.getStatusCode();
            String errorMessage = clientError.getResponseBodyAsString();
            apiResponse.setHttpStatus(httpStatus);
            apiResponse.setMessage(errorMessage);
            log.error("Error POST-request to: {} with status: {} and error: {}", url, httpStatus, errorMessage);
        } catch (ResourceAccessException e) {
            log.error("Timeout exceeded {} with POST-request to: {}", e.getMessage(), url);
            throw new RestRequestFailedException("Timeout exceeded: " + e.getMessage(), e);
        }
        return apiResponse;
    }

    abstract public ApiResponse<Returned> execute(Sent data, Object params);

}
