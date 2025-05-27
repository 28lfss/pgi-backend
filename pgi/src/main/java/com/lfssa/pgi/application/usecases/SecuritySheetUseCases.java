package com.lfssa.pgi.application.usecases;

import com.lfssa.pgi.domain.securitysheet.SecuritySheet;

import java.util.Optional;

public interface SecuritySheetUseCases {
    SecuritySheet createSecuritySheet(SecuritySheet securitySheet, long userId);

    Optional<SecuritySheet> getSecuritySheetById(long id);
}
