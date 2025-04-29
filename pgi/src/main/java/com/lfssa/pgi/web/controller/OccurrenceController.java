package com.lfssa.pgi.web.controller;

import com.lfssa.pgi.application.service.OccurrenceService;
import com.lfssa.pgi.dto.OccurrenceRequest;
import com.lfssa.pgi.dto.OccurrenceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/occurrence")
public class OccurrenceController {
    @Autowired
    private OccurrenceService occurrenceService;

    @PostMapping
    public ResponseEntity<String> createOccurrence(@RequestBody @Valid OccurrenceRequest request) {
        return occurrenceService.createOccurrence(request);
    }

    @GetMapping("/all")
    public List<OccurrenceResponse> findAllOccurrences() {
        return occurrenceService.findAllOccurrences();
    }
}

