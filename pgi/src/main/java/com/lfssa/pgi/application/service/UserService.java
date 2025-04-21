package com.lfssa.pgi.application.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.lfssa.pgi.domain.repository.UserRepository;
import com.lfssa.pgi.domain.model.User;
import com.lfssa.pgi.dto.UserRequest;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(UserRequest request) {
        User newUser = new User();

        newUser.setUsername(request.username);
        newUser.setEmail(request.email);
        newUser.setHashPassword(request.password);
        newUser.setAccessLevel(User.AccessLevel.COLLAB);

        userRepository.createUser(newUser);
    }

    public Optional<User> findUserById(UserRequest request) {
        return userRepository.findUserById(request.userId);
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }

    public Optional<User> findUserByEmail(UserRequest request) {
        return userRepository.findUserByEmail(request.email);
    }
}
