package com.lfssa.pgi.web.controller;

import com.lfssa.pgi.dto.UserResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.lfssa.pgi.application.service.UserService;
import com.lfssa.pgi.dto.UserRequest;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public String createUser(@RequestBody UserRequest request) {
        return userService.createUser(request);
    }

    @GetMapping
    public Optional<UserResponse> findUserById(@RequestBody UserRequest request) {
        return userService.findUserById(request);
    }

    @GetMapping("/all")
    public List<UserResponse> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/email")
    public Optional<UserResponse> findUserByEmail(@RequestBody UserRequest request) {
        return userService.findUserByEmail(request);
    }

    @GetMapping("/login")
    public Boolean existsUserByEmail(@RequestBody UserRequest request) {
        return userService.login(request);
    }
}
