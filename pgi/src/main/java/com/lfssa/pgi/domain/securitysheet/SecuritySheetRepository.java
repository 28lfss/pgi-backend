package com.lfssa.pgi.domain.securitysheet;

public interface SecuritySheetRepository {
    SecuritySheet createSecuritySheet(SecuritySheet securitySheet);

    SecuritySheet getSecuritySheetById(long id);
}
