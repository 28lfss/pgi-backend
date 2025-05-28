package com.lfssa.pgi.application.usecases;

import com.lfssa.pgi.domain.securitysheet.SecuritySheetRequestDTO;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetResponseDTO;

import java.util.List;

public interface SecuritySheetUseCases {
    SecuritySheetResponseDTO createSecuritySheet(SecuritySheetRequestDTO request);

    List<SecuritySheetResponseDTO> getAllSecuritySheetsByFilter(String manufacture, String productType, String productName);

    SecuritySheetResponseDTO getSecuritySheetById(long id);

    String deleteSecuritySheet(long id);
}
