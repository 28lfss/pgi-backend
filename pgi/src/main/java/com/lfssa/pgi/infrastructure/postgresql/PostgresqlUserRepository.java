package com.lfssa.pgi.infrastructure.postgresql;

import com.lfssa.pgi.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostgresqlUserRepository extends JpaRepository<User, Long> {
    Boolean existsUserByEmail(String email);

    Optional<User> findUserByEmail(String email);
}
