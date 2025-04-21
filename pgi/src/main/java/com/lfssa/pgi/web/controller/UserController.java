package com.lfssa.pgi.web.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.lfssa.pgi.application.service.UserService;
import com.lfssa.pgi.domain.model.User;
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
        userService.createUser(request);
        return "User created";
    }

    @GetMapping
    public Optional<User> findUserById(@RequestBody UserRequest request) {
        return userService.findUserById(request);
    }

    @GetMapping("/all")
    public List<User> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/login")
    public Boolean existsUserByEmail(@RequestBody UserRequest request) {
        return userService.existsUserByEmail(request);
    };

    @GetMapping("/email")
    public Optional<User> findUserByEmail(@RequestBody UserRequest request) {
        return userService.findUserByEmail(request);
    }
}
