package com.lfssa.pgi.domain.occurrence;

import com.lfssa.pgi.adapters.outbound.entities.JpaOccurrenceEntity;

import java.util.List;
import java.util.Optional;

public interface OccurrenceRepository {
    void createOccurrence(Occurrence occurrence);

    List<Occurrence> findAllOccurrences();
}
