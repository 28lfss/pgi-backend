package com.lfssa.pgi.application.usecases;

import com.lfssa.pgi.domain.securitysheet.SecuritySheet;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetRequestDTO;

import java.util.Optional;

public interface SecuritySheetUseCases {
    SecuritySheet createSecuritySheet(SecuritySheetRequestDTO request);

    Optional<SecuritySheet> getSecuritySheetById(long id);
}
