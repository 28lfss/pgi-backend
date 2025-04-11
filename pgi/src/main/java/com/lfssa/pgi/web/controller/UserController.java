package com.lfssa.pgi.web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.lfssa.pgi.application.service.UserService;
import com.lfssa.pgi.dto.UserRequest;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public String createUser(@RequestBody UserRequest request) {
        userService.createUser(request);
        return "User created";
    }
}
