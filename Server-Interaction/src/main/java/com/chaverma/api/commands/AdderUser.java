package com.chaverma.api.commands;


import com.chaverma.api.ApiResponse;

import com.chaverma.api.dataSender.DataPostSender;
import com.chaverma.dto.UserDTO;
public class AdderUser extends DataPostSender<UserDTO, Long> {

    public AdderUser(String currentUrl) {
        super(currentUrl);
    }

    @Override
    public ApiResponse<Long> execute(UserDTO data, Object params) {
        return send(data, params);
    }
}
