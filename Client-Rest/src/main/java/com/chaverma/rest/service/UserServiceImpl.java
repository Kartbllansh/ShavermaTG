package com.chaverma.rest.service;

import com.chaverma.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * The type User service.
 */
@Service
@Slf4j
public class UserServiceImpl implements UserService {

    /**
     * Method to save to the database. Not safe, since the user may already be created,
     * an exception is thrown ObjectExistException when this script is executed.
     *
     * @param user the user
     * @return long user id
     */
    @Override
    public long save(UserDTO user) {
        /*logic save in database*/
        return -1;
    }

}
