package com.lfssa.pgi.infrastructure.adapter;

import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import com.lfssa.pgi.domain.repository.UserRepository;
import com.lfssa.pgi.infrastructure.mongo.MongoUserRepository;

@Component
public class UserRepositoryAdapter implements UserRepository {

    @Autowired
    private MongoUserRepository mongoUserRepository;

}
