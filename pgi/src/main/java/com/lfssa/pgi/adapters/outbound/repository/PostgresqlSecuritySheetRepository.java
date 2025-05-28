package com.lfssa.pgi.adapters.outbound.repository;

import com.lfssa.pgi.adapters.outbound.entities.JpaSecuritySheetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostgresqlSecuritySheetRepository extends JpaRepository<JpaSecuritySheetEntity, Long> {

    @Query("SELECT s FROM JpaSecuritySheetEntity s " +
            "WHERE (:manufacture IS NULL OR s.manufacture = :manufacture) " +
            "AND (:productType IS NULL OR s.productType = :productType)" +
            "AND (:productName IS NULL OR s.productName = :productName)"
    )
    List<JpaSecuritySheetEntity> findAllByFilters(
            @Param("manufacture") String manufacture,
            @Param("productType") String productType,
            @Param("productName") String productName
    );
}
