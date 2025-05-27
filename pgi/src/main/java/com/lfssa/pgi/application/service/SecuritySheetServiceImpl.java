package com.lfssa.pgi.application.service;

import com.lfssa.pgi.application.usecases.SecuritySheetUseCases;
import com.lfssa.pgi.domain.securitysheet.SecuritySheet;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetRepository;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetRequestDTO;
import com.lfssa.pgi.domain.user.UserRepository;
import com.lfssa.pgi.utils.SecuritySheetJpaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecuritySheetServiceImpl implements SecuritySheetUseCases {
    @Autowired
    SecuritySheetRepository securitySheetRepository;

    @Autowired
    SecuritySheetJpaMapper mapper;

    @Autowired
    UserRepository userRepository;

    public SecuritySheet createSecuritySheet(SecuritySheetRequestDTO request) {
        SecuritySheet securitySheet = mapper.requestToSecuritySheet(request);
        securitySheet.setCreationTimestamp(System.currentTimeMillis());
        securitySheet.setUser(userRepository.findUserById(request.userId).get());
        securitySheet.setActive(true);

        return securitySheetRepository.createSecuritySheet(securitySheet);
    }

    public Optional<SecuritySheet> getSecuritySheetById(long id) {
        return securitySheetRepository.getSecuritySheetById(id);
    }
}
