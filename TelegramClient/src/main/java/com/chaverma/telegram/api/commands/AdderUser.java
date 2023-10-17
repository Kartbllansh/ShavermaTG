package com.chaverma.telegram.api.commands;

import com.chaverma.telegram.api.ApiResponse;
import com.chaverma.telegram.api.dataSender.DataPostSender;
import com.chaverma.telegram.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource(value = {"classpath:application.properties", "classpath:commands.properties"})
public class AdderUser extends DataPostSender<UserDTO, Long> {

    public AdderUser(@Value("${command.start}") String currentUrl) {
        super(currentUrl);
    }

    @Override
    public ApiResponse<Long> execute(UserDTO data, Object params) {
        return send(data, params);
    }
}
