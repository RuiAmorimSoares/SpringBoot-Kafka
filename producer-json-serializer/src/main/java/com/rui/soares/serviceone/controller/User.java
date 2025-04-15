package com.rui.soares.serviceone.controller;

import com.rui.soares.request.UserRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface User {
    @PostMapping
    ResponseEntity<UserRequest> save(@RequestBody UserRequest userRequest);
}