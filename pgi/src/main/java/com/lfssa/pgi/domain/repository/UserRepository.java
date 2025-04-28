package com.lfssa.pgi.domain.repository;

import com.lfssa.pgi.domain.model.User;

import java.util.UUID;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void createUser(User user);

    Boolean existsUserById(long id);

    Optional<User> findUserById(long id);

    List<User> findAllUsers();

    Boolean existsUserByEmail(String email);

    Optional<User> findUserByEmail(String email);
}
