package com.lfssa.pgi.infrastructure.adapter;

import com.lfssa.pgi.domain.model.Occurrence;
import com.lfssa.pgi.domain.repository.OccurrenceRepository;
import com.lfssa.pgi.infrastructure.postgresql.PostgresqlOccurrenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OccurrenceRepositoryAdapter implements OccurrenceRepository {

    @Autowired
    private PostgresqlOccurrenceRepository postgresqlOccurrenceRepository;

    @Override
    public void createOccurrence(Occurrence occurrence) {
        postgresqlOccurrenceRepository.save(occurrence);
    }

    @Override
    public List<Occurrence> findAllOccurrences() {
        return postgresqlOccurrenceRepository.findAll();
    }
}
