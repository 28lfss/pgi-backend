package com.lfssa.pgi.domain.securitysheet;

import java.util.List;

public interface SecuritySheetRepository {
    SecuritySheet createSecuritySheet(SecuritySheet securitySheet);

    List<SecuritySheet> getAllSecuritySheetsByFilter(SecuritySheet filters);

    SecuritySheet getSecuritySheetById(long id);

    void deleteSecuritySheet(long id);
}
