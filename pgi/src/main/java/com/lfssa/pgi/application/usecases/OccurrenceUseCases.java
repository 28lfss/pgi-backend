package com.lfssa.pgi.application.usecases;

import com.lfssa.pgi.domain.occurrence.OccurrenceRequestDTO;
import com.lfssa.pgi.domain.occurrence.OccurrenceResponseDTO;

import java.util.List;

public interface OccurrenceUseCases {
    OccurrenceResponseDTO createOccurrence(OccurrenceRequestDTO request);

    List<OccurrenceResponseDTO> findAllOccurrences();

    List<OccurrenceResponseDTO> FindOccurrencesByUserId(long userId);

    OccurrenceResponseDTO FindOccurrenceById(long occurrenceId);
}
