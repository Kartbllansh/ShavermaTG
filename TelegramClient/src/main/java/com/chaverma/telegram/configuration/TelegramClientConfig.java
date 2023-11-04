package com.chaverma.telegram.configuration;

import com.chaverma.api.commands.AdderUser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TelegramClientConfig {

@Value("${command.start}")
private String currentUrl;
    @Bean
    public AdderUser AdderUser(){
        return new AdderUser(currentUrl);
    }
}
