package com.lfssa.pgi.domain.repository;

import com.lfssa.pgi.domain.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    void createUser(User user);

    Optional<User> findUserById(String id);

    void deleteUserById(String id);

    List<User> findAllUsers();
}
