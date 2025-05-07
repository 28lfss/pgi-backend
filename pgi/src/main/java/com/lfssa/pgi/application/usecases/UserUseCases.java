package com.lfssa.pgi.application.usecases;

import com.lfssa.pgi.domain.user.UserRequestDTO;
import com.lfssa.pgi.domain.user.UserResponseDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface UserUseCases {
    public ResponseEntity<String> createUser(UserRequestDTO request);

    public Optional<UserResponseDTO> findUserById(UserRequestDTO request);

    public List<UserResponseDTO> findAllUsers();

    public Optional<UserResponseDTO> findUserByEmail(UserRequestDTO request);

    public Boolean login(UserRequestDTO request);
}
