package com.lfssa.pgi.adapters.inboud.controller;

import com.lfssa.pgi.application.usecases.SecuritySheetUseCases;
import com.lfssa.pgi.domain.securitysheet.SecuritySheet;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetRequestDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/sec-sheet")
public class SecuritySheetController {
    @Autowired
    SecuritySheetUseCases useCases;

    @PostMapping
    public SecuritySheet createSecuritySheet(@RequestBody SecuritySheetRequestDTO request) {
        return useCases.createSecuritySheet(request);
    }

    @GetMapping("/{userId}")
    public Optional<SecuritySheet> getSecuritySheetById(@PathVariable long userId) {
        return useCases.getSecuritySheetById(userId);
    }
}
