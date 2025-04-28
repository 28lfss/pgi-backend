package com.lfssa.pgi.infrastructure.adapter;

import com.lfssa.pgi.infrastructure.postgresql.PostgresqlUserRepository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.lfssa.pgi.domain.repository.UserRepository;
import com.lfssa.pgi.domain.model.User;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryAdapter implements UserRepository {

    @Autowired
    PostgresqlUserRepository postgresqlUserRepository;

    @Override
    public void createUser(User user) {
        postgresqlUserRepository.save(user);
    }

    @Override
    public Boolean existsUserById(long id) {
        return postgresqlUserRepository.existsById(id);
    }

    @Override
    public Optional<User> findUserById(long id) {
        return postgresqlUserRepository.findById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return postgresqlUserRepository.findAll();
    }

    @Override
    public Boolean existsUserByEmail(String email) {
        return postgresqlUserRepository.existsUserByEmail(email);
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return postgresqlUserRepository.findUserByEmail(email);
    }
}
