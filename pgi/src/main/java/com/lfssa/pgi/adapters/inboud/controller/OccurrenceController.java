package com.lfssa.pgi.adapters.inboud.controller;

import com.lfssa.pgi.application.usecases.OccurrenceUseCases;
import com.lfssa.pgi.domain.occurrence.OccurrenceRequestDTO;
import com.lfssa.pgi.domain.occurrence.OccurrenceResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/occurrence")
public class OccurrenceController {
    @Autowired
    private OccurrenceUseCases occurrenceUseCases;

    @PostMapping
    public String createOccurrence(@RequestBody @Valid OccurrenceRequestDTO request) {
        return occurrenceUseCases.createOccurrence(request);
    }

    @GetMapping("/all")
    public List<OccurrenceResponseDTO> findAllOccurrences() {
        return occurrenceUseCases.findAllOccurrences();
    }
}

