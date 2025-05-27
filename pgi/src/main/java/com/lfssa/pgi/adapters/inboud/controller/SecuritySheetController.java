package com.lfssa.pgi.adapters.inboud.controller;

import com.lfssa.pgi.application.usecases.SecuritySheetUseCases;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetRequestDTO;
import com.lfssa.pgi.domain.securitysheet.SecuritySheetResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<SecuritySheetResponseDTO>> getAllSecuritySheets() {
        List<SecuritySheetResponseDTO> response = useCases.getAllSecuritySheets();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SecuritySheetResponseDTO> getSecuritySheetById(@PathVariable long id) {
        SecuritySheetResponseDTO response = useCases.getSecuritySheetById(id);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/del/{id}")
    public ResponseEntity<String> deleteSecuritySheet(@PathVariable long id) {
        String response =  useCases.deleteSecuritySheet(id);
        return ResponseEntity.ok(response);
    }
}
