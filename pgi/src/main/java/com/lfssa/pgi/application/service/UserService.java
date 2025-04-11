package com.lfssa.pgi.application.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.lfssa.pgi.domain.repository.UserRepository;
import com.lfssa.pgi.domain.model.User;
import com.lfssa.pgi.dto.UserRequest;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createUser(UserRequest user) {
        User newUser = new User();
        newUser.setUserId(user.userId);
        newUser.setUsername(user.username);
        userRepository.createUser(newUser);
    }
}
