package com.chaverma.telegram.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class UserDTO {
    private long id;

    private String username;

    private Date dateRegistration;
}
