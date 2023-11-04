package com.chaverma.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;



public record UserDTO(
        Long telegramId, String firstName, String lastName, String username
){}