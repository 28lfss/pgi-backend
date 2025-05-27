package com.lfssa.pgi.utils;

import com.lfssa.pgi.adapters.outbound.entities.JpaSecuritySheetEntity;
import com.lfssa.pgi.domain.securitysheet.SecuritySheet;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetRequestDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SecuritySheetJpaMapper {
    SecuritySheet jpaToSecuritySheet(JpaSecuritySheetEntity securitySheet);

    JpaSecuritySheetEntity securitySheetToJpa(SecuritySheet securitySheet);

    SecuritySheet requestToSecuritySheet(SecuritySheetRequestDTO request);
}
