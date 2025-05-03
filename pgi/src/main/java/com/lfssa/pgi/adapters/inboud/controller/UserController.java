package com.lfssa.pgi.adapters.inboud.controller;

import com.lfssa.pgi.application.usecases.UserUseCases;
import com.lfssa.pgi.domain.user.UserResponseDTO;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.lfssa.pgi.domain.user.UserRequestDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    private UserUseCases userUseCases;

    @PostMapping
    public String createUser(@RequestBody UserRequestDTO request) {
        return userUseCases.createUser(request);
    }

    @GetMapping
    public Optional<UserResponseDTO> findUserById(@RequestBody UserRequestDTO request) {
        return userUseCases.findUserById(request);
    }

    @GetMapping("/all")
    public List<UserResponseDTO> findAllUsers() {
        return userUseCases.findAllUsers();
    }

    @GetMapping("/email")
    public Optional<UserResponseDTO> findUserByEmail(@RequestBody UserRequestDTO request) {
        return userUseCases.findUserByEmail(request);
    }

    @GetMapping("/login")
    public Boolean existsUserByEmail(@RequestBody UserRequestDTO request) {
        return userUseCases.login(request);
    }
}
