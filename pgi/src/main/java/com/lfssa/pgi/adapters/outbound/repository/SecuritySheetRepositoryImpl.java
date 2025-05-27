package com.lfssa.pgi.adapters.outbound.repository;

import com.lfssa.pgi.domain.securitysheet.SecuritySheet;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetRepository;
import com.lfssa.pgi.utils.SecuritySheetJpaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecuritySheetRepositoryImpl implements SecuritySheetRepository {
    @Autowired
    PostgresqlSecuritySheetRepository postgresqlRepository;

    @Autowired
    SecuritySheetJpaMapper mapper;

    public SecuritySheet createSecuritySheet(SecuritySheet securitySheet) {
        return mapper.jpaToSecuritySheet(postgresqlRepository.save(mapper.securitySheetToJpa(securitySheet)));
    }

    public Optional<SecuritySheet> getSecuritySheetById(long id) {
        return postgresqlRepository.findById(id).map(mapper::jpaToSecuritySheet);
    }
}
