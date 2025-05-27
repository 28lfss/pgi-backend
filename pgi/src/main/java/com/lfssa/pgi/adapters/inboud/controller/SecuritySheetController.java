package com.lfssa.pgi.adapters.inboud.controller;

import com.lfssa.pgi.application.usecases.SecuritySheetUseCases;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetRequestDTO;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/sec-sheet")
public class SecuritySheetController {
    @Autowired
    SecuritySheetUseCases useCases;

    @PostMapping
    public ResponseEntity<SecuritySheetResponseDTO> createSecuritySheet(@RequestBody SecuritySheetRequestDTO request) {
        SecuritySheetResponseDTO response = useCases.createSecuritySheet(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<SecuritySheetResponseDTO> getSecuritySheetById(@PathVariable long userId) {
        SecuritySheetResponseDTO response = useCases.getSecuritySheetById(userId);
        return ResponseEntity.ok(response);
    }
}
