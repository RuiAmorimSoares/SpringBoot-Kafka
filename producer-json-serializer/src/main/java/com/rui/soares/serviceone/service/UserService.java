package com.rui.soares.serviceone.service;

import com.rui.soares.request.UserRequest;

/**
 * UserService interface defines the contract for user-related operations.
 * It provides a method to save user requests.
 */
public interface UserService {
    /**
     * Saves the given user request.
     *
     * @param userRequest The user request to be saved.
     */
    void save(UserRequest userRequest);
}