package com.lfssa.pgi.infrastructure.mongo;

import org.springframework.stereotype.Repository;
import com.lfssa.pgi.domain.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface MongoUserRepository extends MongoRepository<User, String> {

}
