package com.chaverma.rest.controller;


import com.chaverma.rest.dto.UserDTO;
import com.chaverma.rest.response.ResponseHandler;
import com.chaverma.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type User controller.
 *
 * <p>
 * Class for controls requests for rest api by request /api/users for user
 * </p>
 */
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    /**
     * Instantiates a new User controller.
     *
     * @param userService the user service
     */
    public UserController(@Autowired UserService userService) {
        this.userService = userService;
    }

    /**
     * Add user and return id by request /api/users/save.
     *
     * @param user the user
     * @return the long
     */
    @PostMapping("/save")
    public ResponseEntity<Object> addUser(@RequestBody UserDTO user) {
        long id = userService.save(user);
        return ResponseHandler.responseBuilder("User was added", HttpStatus.CREATED, id);
    }
}
