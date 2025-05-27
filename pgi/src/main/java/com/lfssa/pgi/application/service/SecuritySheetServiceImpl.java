package com.lfssa.pgi.application.service;

import com.lfssa.pgi.application.usecases.SecuritySheetUseCases;
import com.lfssa.pgi.domain.securitysheet.SecuritySheet;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetRepository;
import com.lfssa.pgi.domain.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecuritySheetServiceImpl implements SecuritySheetUseCases {
    @Autowired
    SecuritySheetRepository securitySheetRepository;

    @Autowired
    UserRepository userRepository;

    public SecuritySheet createSecuritySheet(SecuritySheet securitySheet, long userId) {
        securitySheet.setCreationTimestamp(System.currentTimeMillis());
        securitySheet.setUser(userRepository.findUserById(userId).get());
        securitySheet.setStatus(SecuritySheet.Status.active);
        return securitySheetRepository.createSecuritySheet(securitySheet);
    }

    public Optional<SecuritySheet> getSecuritySheetById(long id) {
        return securitySheetRepository.getSecuritySheetById(id);
    }
}
