package com.lfssa.pgi.adapters.outbound.repository;

import com.lfssa.pgi.adapters.outbound.entities.JpaOccurrenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresqlOccurrenceRepository extends JpaRepository<JpaOccurrenceEntity, Long>{

}