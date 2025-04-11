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

    public void createUser(UserRequest user) {
        User newUser = new User();

        newUser.setUserId(user.userId);
        newUser.setUsername(user.username);
        newUser.setEmail(user.email);
        newUser.setHashedPassword(user.password);

        userRepository.createUser(newUser);
    }

    public Optional<User> findUserById(UserRequest request) {
        return userRepository.findUserById(request.id);
    }

    public void deleteUserById(UserRequest request) {
        userRepository.deleteUserById(request.id);
    }

    public List<User> findAllUsers() {
        return userRepository.findAllUsers();
    }
}
