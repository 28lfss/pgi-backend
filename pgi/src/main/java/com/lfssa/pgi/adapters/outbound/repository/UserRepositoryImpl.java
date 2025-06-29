package com.lfssa.pgi.adapters.outbound.repository;

import com.lfssa.pgi.utils.UserJpaMapper;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.lfssa.pgi.domain.user.UserRepository;
import com.lfssa.pgi.domain.user.User;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    PostgresqlUserRepository postgresqlUserRepository;

    @Autowired
    UserJpaMapper userMapper;

    public User createUser(User user) {
        return userMapper.jpaUserToUser(postgresqlUserRepository.save(userMapper.userToJpaUser(user)));
    }

    public Boolean existsUserById(long id) {
        return postgresqlUserRepository.existsById(id);
    }

    public Optional<User> findUserById(long id) {
        return postgresqlUserRepository.findById(id).map(userMapper::jpaUserToUser);
    }

    public List<User> findAllUsers() {
        return postgresqlUserRepository.findAll().stream().map(userMapper::jpaUserToUser).collect(Collectors.toList());
    }

    public Boolean existsUserByEmail(String email) {
        return postgresqlUserRepository.existsUserByEmail(email);
    }

    public Optional<User> findUserByEmail(String email) {
        return postgresqlUserRepository.findUserByEmail(email).map(userMapper::jpaUserToUser);
    }

    public Boolean existsUserByUsername(String username) {
        return postgresqlUserRepository.existsUserByUsername(username);
    }
}
