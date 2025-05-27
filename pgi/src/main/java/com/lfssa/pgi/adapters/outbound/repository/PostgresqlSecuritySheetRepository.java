package com.lfssa.pgi.adapters.outbound.repository;

import com.lfssa.pgi.adapters.outbound.entities.JpaSecuritySheetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostgresqlSecuritySheetRepository extends JpaRepository<JpaSecuritySheetEntity, Long> {
}
