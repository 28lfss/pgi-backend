package com.lfssa.pgi.web.controller;

import com.lfssa.pgi.application.service.OccurrenceService;
import com.lfssa.pgi.dto.OccurrenceRequest;
import com.lfssa.pgi.dto.OccurrenceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/occurrence")
public class OccurrenceController {
    @Autowired
    private OccurrenceService occurrenceService;

    @PostMapping
    public String createOccurrence(@RequestBody OccurrenceRequest request) {
        return occurrenceService.createOccurrence(request);
    }

    @GetMapping("/all")
    public List<OccurrenceResponse> findAllOccurrences() {
        return occurrenceService.findAllOccurrences();
    }
}

