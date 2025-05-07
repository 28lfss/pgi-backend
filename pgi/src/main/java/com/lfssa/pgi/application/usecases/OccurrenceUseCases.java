package com.lfssa.pgi.application.usecases;

import com.lfssa.pgi.domain.occurrence.OccurrenceRequestDTO;
import com.lfssa.pgi.domain.occurrence.OccurrenceResponseDTO;

import java.util.List;

public interface OccurrenceUseCases {
    String createOccurrence(OccurrenceRequestDTO request);

    List<OccurrenceResponseDTO> findAllOccurrences();
}
