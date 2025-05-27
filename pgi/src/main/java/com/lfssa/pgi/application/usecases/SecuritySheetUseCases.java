package com.lfssa.pgi.application.usecases;

import com.lfssa.pgi.domain.securitysheet.SecuritySheetRequestDTO;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetResponseDTO;

public interface SecuritySheetUseCases {
    SecuritySheetResponseDTO createSecuritySheet(SecuritySheetRequestDTO request);

    SecuritySheetResponseDTO getSecuritySheetById(long id);
}
