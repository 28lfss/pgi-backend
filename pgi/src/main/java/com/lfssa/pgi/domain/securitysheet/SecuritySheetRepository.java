package com.lfssa.pgi.domain.securitysheet;

import java.util.List;

public interface SecuritySheetRepository {
    SecuritySheet createSecuritySheet(SecuritySheet securitySheet);

    List<SecuritySheet> getAllSecuritySheets();

    SecuritySheet getSecuritySheetById(long id);
}
