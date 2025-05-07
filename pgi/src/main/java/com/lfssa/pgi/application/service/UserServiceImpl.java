package com.lfssa.pgi.application.service;

import com.lfssa.pgi.application.usecases.UserUseCases;
import com.lfssa.pgi.domain.user.UserResponseDTO;
import com.lfssa.pgi.utils.UserJpaMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.lfssa.pgi.domain.user.UserRepository;
import com.lfssa.pgi.domain.user.User;
import com.lfssa.pgi.domain.user.UserRequestDTO;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserUseCases {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserJpaMapper userMapper;

    public ResponseEntity<String> createUser(UserRequestDTO request) {
        ResponseEntity<String> response = new ResponseEntity<>("Username or Email already been used", HttpStatus.BAD_REQUEST);

        if(!userRepository.existsUserByEmail(request.email) & !userRepository.existsUserByUsername(request.username)) {
            User newUser = new User();
            newUser.setUsername(request.username);
            newUser.setEmail(request.email);
            newUser.setHashPassword(request.password);
            newUser.setAccessLevel(User.AccessLevel.collab);
            newUser.setActive(true);
            userRepository.createUser(newUser);

            response = new ResponseEntity<>("OK", HttpStatus.CREATED);
        }
        return response;
    }

    public Optional<UserResponseDTO> findUserById(UserRequestDTO request) {
        return userRepository.findUserById(request.userId).map(userMapper::userToResponse);
    }

    public List<UserResponseDTO> findAllUsers() {
        return userRepository.findAllUsers().stream().map(userMapper::userToResponse).collect(Collectors.toList());
    }

    public Optional<UserResponseDTO> findUserByEmail(UserRequestDTO request) {
        return userRepository.findUserByEmail(request.email).map(userMapper::userToResponse);
    }

    public Boolean login(UserRequestDTO request) {
        boolean response = false;
        // TODO: update for hash password decoder;
        if (userRepository.existsUserByEmail(request.email)) {
            Optional<User> user = userRepository.findUserByEmail(request.email);
            response = Objects.equals(user.get().getHashPassword(), request.password);
        }
        return response;
    }
}
