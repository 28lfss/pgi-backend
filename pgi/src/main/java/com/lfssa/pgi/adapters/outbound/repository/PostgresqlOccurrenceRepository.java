package com.lfssa.pgi.adapters.outbound.repository;

import com.lfssa.pgi.adapters.outbound.entities.JpaOccurrenceEntity;
import com.lfssa.pgi.adapters.outbound.entities.JpaUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostgresqlOccurrenceRepository extends JpaRepository<JpaOccurrenceEntity, Long>{
    @Query("SELECT occ FROM JpaOccurrenceEntity occ WHERE occ.user = :user")
    List<JpaOccurrenceEntity> FindOccurrencesByUser(@Param("user") JpaUserEntity user);
}