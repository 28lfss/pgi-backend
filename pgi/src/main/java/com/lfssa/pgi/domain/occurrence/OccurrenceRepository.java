package com.lfssa.pgi.domain.occurrence;

import java.util.List;

public interface OccurrenceRepository {
    void createOccurrence(Occurrence occurrence);

    List<Occurrence> findAllOccurrences();
}
