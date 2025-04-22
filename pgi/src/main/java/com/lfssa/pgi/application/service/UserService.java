package com.lfssa.pgi.application.service;

import com.lfssa.pgi.dto.UserResponse;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.lfssa.pgi.domain.repository.UserRepository;
import com.lfssa.pgi.domain.model.User;
import com.lfssa.pgi.dto.UserRequest;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public String createUser(UserRequest request) {
        User newUser = new User();

        newUser.setUsername(request.username);
        newUser.setEmail(request.email);
        newUser.setHashPassword(request.password);
        newUser.setAccessLevel(User.AccessLevel.COLLAB);

        userRepository.createUser(newUser);
        return "User Created";
    }

    public Optional<UserResponse> findUserById(UserRequest request) {
        return userRepository.findUserById(request.userId).map(UserResponse::from);
    }

    public List<UserResponse> findAllUsers() {
        return userRepository.findAllUsers().stream().map(UserResponse::from).collect(Collectors.toList());
    }

    public Optional<UserResponse> findUserByEmail(UserRequest request) {
        return userRepository.findUserByEmail(request.email).map(UserResponse::from);
    }

    public Boolean login(UserRequest request) {
        boolean response = false;
        if (userRepository.existsUserByEmail(request.email)) {
            Optional<User> user = userRepository.findUserByEmail(request.email);
            response = Objects.equals(user.get().getHashPassword(), request.password);
        }
        return response;
    }
}
