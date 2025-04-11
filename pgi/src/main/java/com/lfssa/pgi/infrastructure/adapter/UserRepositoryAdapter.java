package com.lfssa.pgi.infrastructure.adapter;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.lfssa.pgi.domain.repository.UserRepository;
import com.lfssa.pgi.infrastructure.mongo.MongoUserRepository;
import com.lfssa.pgi.domain.model.User;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryAdapter implements UserRepository {

    @Autowired
    private MongoUserRepository mongoUserRepository;

    @Override
    public void createUser(User user) {
        mongoUserRepository.save(user);
    }

    @Override
    public Optional<User> findUserById(String id) {
        return mongoUserRepository.findById(id);
    }

    @Override
    public void deleteUserById(String id) {
        mongoUserRepository.deleteById(id);
    }

    @Override
    public List<User> findAllUsers() {
        return mongoUserRepository.findAll();
    }
}
