package com.shaverma.rest.service;

import com.chaverma.dto.UserDTO;

public interface UserService {
    /**
     * Save user and return id this user.
     *
     * @param user the user
     * @return the long
     */
    long save(UserDTO user);
}