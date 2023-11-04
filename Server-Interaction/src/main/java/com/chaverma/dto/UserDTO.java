package com.chaverma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {
    private long id;

    private String username;

    private Date dateRegistration;
}
