package com.lfssa.pgi.infrastructure.postgresql;

import com.lfssa.pgi.domain.model.Occurrence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresqlOccurrenceRepository extends JpaRepository<Occurrence, Long> {
}
