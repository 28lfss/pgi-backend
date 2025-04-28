package com.lfssa.pgi.domain.repository;

import com.lfssa.pgi.domain.model.Occurrence;

import java.util.List;

public interface OccurrenceRepository{
    void createOccurrence(Occurrence occurrence);

    List<Occurrence> findAllOccurrences();
}
