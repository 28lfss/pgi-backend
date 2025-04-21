package com.lfssa.pgi.infrastructure.postgresql;

import com.lfssa.pgi.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PostgresqlUserRepository extends JpaRepository<User, UUID> {
    Boolean existsUserByEmail(String email);

    Optional<User> findUserByEmail(String email);
}
