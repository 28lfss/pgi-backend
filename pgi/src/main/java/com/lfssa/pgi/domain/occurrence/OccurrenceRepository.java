package com.lfssa.pgi.domain.occurrence;

import com.lfssa.pgi.domain.user.User;

import java.util.List;

public interface OccurrenceRepository {
    Occurrence createOccurrence(Occurrence occurrence);

    List<Occurrence> findAllOccurrences();

    List<Occurrence> FindOccurrencesByUser(User user);
}
