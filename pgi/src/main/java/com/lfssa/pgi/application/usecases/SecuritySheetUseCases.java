package com.lfssa.pgi.application.usecases;

import com.lfssa.pgi.domain.securitysheet.SecuritySheetRequestDTO;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetResponseDTO;

import java.util.List;

public interface SecuritySheetUseCases {
    SecuritySheetResponseDTO createSecuritySheet(SecuritySheetRequestDTO request);

    List<SecuritySheetResponseDTO> getAllSecuritySheets();

    SecuritySheetResponseDTO getSecuritySheetById(long id);

    String deleteSecuritySheet(long id);
}
