package com.lfssa.pgi.application.service;

import com.lfssa.pgi.application.usecases.SecuritySheetUseCases;
import com.lfssa.pgi.domain.securitysheet.SecuritySheet;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetRepository;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetRequestDTO;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetResponseDTO;
import com.lfssa.pgi.domain.user.UserRepository;
import com.lfssa.pgi.utils.SecuritySheetJpaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecuritySheetServiceImpl implements SecuritySheetUseCases {
    @Autowired
    SecuritySheetRepository securitySheetRepository;

    @Autowired
    SecuritySheetJpaMapper mapper;

    @Autowired
    UserRepository userRepository;

    public SecuritySheetResponseDTO createSecuritySheet(SecuritySheetRequestDTO request) {
        SecuritySheet newSecuritySheet = mapper.requestToSecuritySheet(request);
        newSecuritySheet.setCreationTimestamp(System.currentTimeMillis());
        newSecuritySheet.setUser(userRepository.findUserById(request.userId).get());
        newSecuritySheet.setActive(true);

        return mapper.securitySheetToResponse(securitySheetRepository.createSecuritySheet(newSecuritySheet));
    }

    public List<SecuritySheetResponseDTO> getAllSecuritySheets() {
        return securitySheetRepository.getAllSecuritySheets().stream().map(mapper::securitySheetToResponse).collect(Collectors.toList());
    }

    public SecuritySheetResponseDTO getSecuritySheetById(long id) {
        return mapper.securitySheetToResponse(securitySheetRepository.getSecuritySheetById(id));
    }
}
