package com.lfssa.pgi.domain.securitysheet;

import java.util.Optional;

public interface SecuritySheetRepository {
    SecuritySheet createSecuritySheet(SecuritySheet securitySheet);

    Optional<SecuritySheet> getSecuritySheetById(long id);
}
