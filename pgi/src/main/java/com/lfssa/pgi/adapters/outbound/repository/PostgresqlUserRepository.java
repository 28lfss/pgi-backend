package com.lfssa.pgi.adapters.outbound.repository;

import com.lfssa.pgi.adapters.outbound.entities.JpaUserEntity;
import com.lfssa.pgi.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostgresqlUserRepository extends JpaRepository<JpaUserEntity, Long> {
    Boolean existsUserByEmail(String email);

    Optional<JpaUserEntity> findUserByEmail(String email);
}
