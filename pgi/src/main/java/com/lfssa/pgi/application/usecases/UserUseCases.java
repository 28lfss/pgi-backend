package com.lfssa.pgi.application.usecases;

import com.lfssa.pgi.domain.user.UserRequestDTO;
import com.lfssa.pgi.domain.user.UserResponseDTO;

import java.util.List;

public interface UserUseCases {
    public UserResponseDTO createUser(UserRequestDTO request);

    public UserResponseDTO findUserById(UserRequestDTO request);

    public List<UserResponseDTO> findAllUsers();

    public UserResponseDTO findUserByEmail(UserRequestDTO request);

    public UserResponseDTO login(UserRequestDTO request);
}
