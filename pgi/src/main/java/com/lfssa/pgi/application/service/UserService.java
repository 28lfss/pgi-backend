package com.lfssa.pgi.application.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.lfssa.pgi.domain.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
}
