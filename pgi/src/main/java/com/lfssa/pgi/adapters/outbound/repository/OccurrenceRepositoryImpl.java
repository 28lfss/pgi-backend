package com.lfssa.pgi.adapters.outbound.repository;

import com.lfssa.pgi.adapters.outbound.entities.JpaOccurrenceEntity;
import com.lfssa.pgi.domain.occurrence.Occurrence;
import com.lfssa.pgi.domain.occurrence.OccurrenceRepository;
import com.lfssa.pgi.utils.OccurrenceJpaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OccurrenceRepositoryImpl implements OccurrenceRepository {

    @Autowired
    private PostgresqlOccurrenceRepository postgresqlOccurrenceRepository;

    @Autowired
    private OccurrenceJpaMapper occurrenceJpaMapper;

    @Override
    public void createOccurrence(Occurrence occurrence) {
        JpaOccurrenceEntity occurrenceEntity = occurrenceJpaMapper.occurrenceToJpaOccurrence(occurrence);
    }

    @Override
    public List<Occurrence> findAllOccurrences() {
        return postgresqlOccurrenceRepository.findAll().stream().map(occurrenceJpaMapper::jpaOccurrenceToOccurrence).collect(Collectors.toList());
    }
}