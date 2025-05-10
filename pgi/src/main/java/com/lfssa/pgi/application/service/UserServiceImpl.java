package com.lfssa.pgi.application.service;

import com.lfssa.pgi.application.usecases.UserUseCases;
import com.lfssa.pgi.domain.user.UserResponseDTO;
import com.lfssa.pgi.infrastructure.config.exceptions.InvalidCredentialsException;
import com.lfssa.pgi.infrastructure.config.exceptions.UserAlreadyExistsException;
import com.lfssa.pgi.infrastructure.config.exceptions.UserNotFoundException;
import com.lfssa.pgi.utils.UserJpaMapper;
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

    public UserResponseDTO createUser(UserRequestDTO request)    {
        if (userRepository.existsUserByUsername(request.username)) {
            throw new UserAlreadyExistsException("Username already in use");
        }

        if (userRepository.existsUserByEmail(request.email)) {
            throw new UserAlreadyExistsException("Email already in use");
        }

        User newUser = new User();
        newUser.setUsername(request.username);
        newUser.setEmail(request.email);
        newUser.setHashPassword(request.password);
        newUser.setAccessLevel(User.AccessLevel.collab);
        newUser.setActive(true);
        User createdUser = userRepository.createUser(newUser);

        return userMapper.userToResponse(createdUser);
    }

    public UserResponseDTO findUserById(UserRequestDTO request) {
        if (!userRepository.existsUserById(request.userId)) {
            throw new UserNotFoundException("User not found");
        }

        Optional<User> user = (userRepository.findUserById(request.userId));

        return userMapper.userToResponse(user.get());
    }

    public List<UserResponseDTO> findAllUsers() {
        List<User> usersList = userRepository.findAllUsers();
        List<UserResponseDTO> responseList = usersList.stream().map(userMapper::userToResponse).collect(Collectors.toList());

        return responseList;
    }

    public UserResponseDTO findUserByEmail(UserRequestDTO request) {
        if (!userRepository.existsUserByEmail(request.email)) {
            throw new UserNotFoundException("User not found");
        }

        Optional<User> user = (userRepository.findUserByEmail(request.email));

        return userMapper.userToResponse(user.get());
    }

    public UserResponseDTO login(UserRequestDTO request) {
        if (!userRepository.existsUserByEmail(request.email)) {
            throw new UserNotFoundException("User not found with email: " + request.email);
        }

        Optional<User> user = userRepository.findUserByEmail(request.email);

        // TODO: update for hash password decoder;
        if (user.isEmpty() || !Objects.equals(user.get().getHashPassword(), request.password)) {
            throw new InvalidCredentialsException("Invalid email or password");
        }

        return userMapper.userToResponse(user.get());
    }
}
