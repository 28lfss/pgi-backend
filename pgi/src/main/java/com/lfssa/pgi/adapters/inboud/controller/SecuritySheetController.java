package com.lfssa.pgi.adapters.inboud.controller;

import com.lfssa.pgi.application.usecases.SecuritySheetUseCases;
import com.lfssa.pgi.domain.securitysheet.SecuritySheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/v1/sec-sheet")
public class SecuritySheetController {
    @Autowired
    SecuritySheetUseCases useCases;

    @PostMapping("/test/{userId}")
    public SecuritySheet createSecuritySheet(@RequestBody SecuritySheet securitySheet, @PathVariable long userId) {
        return useCases.createSecuritySheet(securitySheet, userId);
    }

    @GetMapping("/{userId}")
    public Optional<SecuritySheet> getSecuritySheetById(@PathVariable long userId) {
        return useCases.getSecuritySheetById(userId);
    }
}
