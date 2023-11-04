package com.shaverma.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.shaverma.database.dao", "com.shaverma.rest"})
public class ClientRestApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientRestApplication.class, args);
    }

}
