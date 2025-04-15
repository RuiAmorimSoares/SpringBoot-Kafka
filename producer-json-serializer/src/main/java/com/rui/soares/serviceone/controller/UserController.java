package com.rui.soares.serviceone.controller;

import com.rui.soares.request.UserRequest;
import com.rui.soares.serviceone.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

/**
 * UserController is responsible for handling user-related requests.
 * It implements the User interface and uses the UserService to process user data.
 */
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/user")
public class UserController implements User {
    private final UserService userService;

    /**
     * Handles the request to save a user.
     * It receives a UserRequest object, processes it using the UserService,
     * and returns a ResponseEntity indicating the result of the operation.
     *
     * @param userRequest The UserRequest object containing user data.
     * @return ResponseEntity indicating the result of the save operation.
     */
    @Override
    public ResponseEntity<UserRequest> save(final UserRequest userRequest) {
        userService.save(userRequest);
        return ResponseEntity.created(URI.create("/user")).build();
    }
}
