package com.lfssa.pgi.domain.user;

import java.util.List;
import java.util.Optional;

public interface UserRepository {

    User createUser(User user);

    Boolean existsUserById(long id);

    Optional<User> findUserById(long id);

    List<User> findAllUsers();

    Boolean existsUserByEmail(String email);

    Optional<User> findUserByEmail(String email);

    Boolean existsUserByUsername(String username);
}
