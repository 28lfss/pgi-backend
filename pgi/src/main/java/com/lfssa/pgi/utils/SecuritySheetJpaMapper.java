package com.lfssa.pgi.utils;

import com.lfssa.pgi.adapters.outbound.entities.JpaSecuritySheetEntity;
import com.lfssa.pgi.domain.securitysheet.SecuritySheet;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetRequestDTO;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetResponseDTO;
import com.lfssa.pgi.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface SecuritySheetJpaMapper {
    SecuritySheet jpaToSecuritySheet(JpaSecuritySheetEntity securitySheet);

    JpaSecuritySheetEntity securitySheetToJpa(SecuritySheet securitySheet);

    @Mapping(target = "securitySheetId", ignore = true)
    @Mapping(target = "creationTimestamp", ignore = true)
    @Mapping(target = "user", ignore = true)
    @Mapping(target = "active", ignore = true)
    SecuritySheet requestToSecuritySheet(SecuritySheetRequestDTO request);

    @Mapping(source = "user", target = "registrantId", qualifiedByName = "getRegistrantId")
    SecuritySheetResponseDTO securitySheetToResponse(SecuritySheet securitySheet);

    @Named("getRegistrantId")
    static long getRegistrantId(User user) {
        return user.getUserId();
    }
}
