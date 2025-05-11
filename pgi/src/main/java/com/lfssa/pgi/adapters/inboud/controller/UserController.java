package com.lfssa.pgi.adapters.inboud.controller;

import com.lfssa.pgi.application.usecases.UserUseCases;
import com.lfssa.pgi.domain.user.UserResponseDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import com.lfssa.pgi.domain.user.UserRequestDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/user")
public class UserController {
    @Autowired
    private UserUseCases userUseCases;

    @PostMapping
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO request) {
        UserResponseDTO response = userUseCases.createUser(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDTO> findUserById(@PathVariable long userId) {
        UserResponseDTO response = userUseCases.findUserById(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDTO>> findAllUsers() {
        List<UserResponseDTO> response = userUseCases.findAllUsers();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/email")
    public ResponseEntity<UserResponseDTO> findUserByEmail(@RequestBody UserRequestDTO request) {
        UserResponseDTO response = userUseCases.findUserByEmail(request);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponseDTO> existsUserByEmail(@RequestBody UserRequestDTO request) {
        UserResponseDTO response = userUseCases.login(request);
        return ResponseEntity.ok(response);
    }
}
