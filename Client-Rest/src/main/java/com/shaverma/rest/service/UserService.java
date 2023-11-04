package com.shaverma.rest.service;

import com.chaverma.dto.UserDTO;
import com.shaverma.database.entity.user.TelegramUser;

import java.util.Optional;

public interface UserService {
    /**
     * Save user and return id this user.
     *
     * @param user the user
     * @return the long
     */
    long saveTelegramUser(UserDTO user);

    TelegramUser findById(Long id);
}