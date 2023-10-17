package com.chaverma.rest.service;

import com.chaverma.rest.dto.UserDTO;

public interface UserService {
    /**
     * Save user and return id this user.
     *
     * @param user the user
     * @return the long
     */
    long save(UserDTO user);
}