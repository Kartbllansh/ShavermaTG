package com.chaverma.rest.dto;



import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private long id;

    private String username;

    private Date dateRegistration;
}
