package com.lfssa.pgi.adapters.inboud.controller;

import com.lfssa.pgi.application.usecases.OccurrenceUseCases;
import com.lfssa.pgi.domain.occurrence.OccurrenceRequestDTO;
import com.lfssa.pgi.domain.occurrence.OccurrenceResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/occurrence")
public class OccurrenceController {
    @Autowired
    private OccurrenceUseCases occurrenceUseCases;

    @PostMapping
    public ResponseEntity<OccurrenceResponseDTO> createOccurrence(@RequestBody @Valid OccurrenceRequestDTO request) {
        OccurrenceResponseDTO response = occurrenceUseCases.createOccurrence(request);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<OccurrenceResponseDTO>> findAllOccurrences() {
        List<OccurrenceResponseDTO> response = occurrenceUseCases.findAllOccurrences();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/all/{userId}")
    public ResponseEntity<List<OccurrenceResponseDTO>> FindOccurrencesByUserId(@PathVariable long userId) {
        List<OccurrenceResponseDTO> response = occurrenceUseCases.FindOccurrencesByUserId(userId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{occurrenceId}")
    public ResponseEntity<OccurrenceResponseDTO> FindOccurrenceById(@PathVariable long occurrenceId) {
        OccurrenceResponseDTO response = occurrenceUseCases.FindOccurrenceById(occurrenceId);
        return ResponseEntity.ok(response);
    }
}
