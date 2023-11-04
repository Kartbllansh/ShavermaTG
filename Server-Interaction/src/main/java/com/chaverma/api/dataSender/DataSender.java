package com.chaverma.api.dataSender;

import com.chaverma.api.ApiResponse;
import jakarta.annotation.PostConstruct;
import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.UsernamePasswordCredentials;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.auth.BasicCredentialsProvider;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;


abstract public class DataSender<Returned> {

    protected final int CONST_TIMEOUT = 500;

    @Value("${rest.server.host}")
    private String host;
    @Value("${rest.server.port}")
    private int port;

    @Value("${rest.server.username}")
    private String username;
    @Value("${rest.server.password}")
    private String password;
    protected ApiResponse<Returned> apiResponse;
    protected ResponseEntity<ApiResponse<Returned>> responseEntity;

    protected String url;


    @Value("${rest.server.url}")
    private String baseUrl;

    public DataSender(String currentUrl) {
        this.url = currentUrl;
    }

    @PostConstruct
    public void init() {
        this.url = baseUrl + this.url;
    }

    protected RestTemplate buildRestTemplate(int timeout) {
        HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        httpRequestFactory.setConnectionRequestTimeout(timeout);
        httpRequestFactory.setConnectTimeout(timeout);

        BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(new AuthScope(host, port),
                new UsernamePasswordCredentials(username, password.toCharArray()));

        // Получите HttpClient из CloseableHttpClient
        HttpClient httpClient = HttpClients.custom()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();

        httpRequestFactory.setHttpClient(httpClient);



        return new RestTemplate(httpRequestFactory);
    }

    protected <Sent> HttpEntity<Sent> buildHttpEntity(Sent data) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        return new HttpEntity<>(data, headers);
    }


    public ApiResponse<Returned> getApiResponse() {
        return apiResponse;
    }


    public boolean isSuccessfullyResponse() {
        return apiResponse.getHttpStatus().is2xxSuccessful();
    }


}
