package com.lfssa.pgi.adapters.outbound.repository;

import com.lfssa.pgi.domain.occurrence.Occurrence;
import com.lfssa.pgi.domain.occurrence.OccurrenceRepository;
import com.lfssa.pgi.domain.user.User;
import com.lfssa.pgi.utils.OccurrenceJpaMapper;
import com.lfssa.pgi.utils.UserJpaMapper;
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

    @Autowired
    private UserJpaMapper userJpaMapper;

    public Occurrence createOccurrence(Occurrence occurrence) {
        return occurrenceJpaMapper
                .jpaOccurrenceToOccurrence(
                        postgresqlOccurrenceRepository.save(
                                occurrenceJpaMapper.occurrenceToJpaOccurrence(occurrence)
                        )
                );
    }

    public List<Occurrence> findAllOccurrences() {
        return postgresqlOccurrenceRepository
                .findAll()
                .stream()
                .map(occurrenceJpaMapper::jpaOccurrenceToOccurrence)
                .collect(Collectors.toList());
    }

    public List<Occurrence> FindOccurrencesByUser(User user) {
        return postgresqlOccurrenceRepository
                .FindOccurrencesByUser(userJpaMapper.userToJpaUser(user))
                .stream()
                .map(occurrenceJpaMapper::jpaOccurrenceToOccurrence)
                .collect(Collectors.toList());
    }

    public boolean ExistsById(long occurrenceId) {
        return postgresqlOccurrenceRepository.existsById(occurrenceId);
    }

    public Occurrence FindOccurrenceById(long occurrenceId) {
        return postgresqlOccurrenceRepository.findById(occurrenceId).map(occurrenceJpaMapper::jpaOccurrenceToOccurrence).get();
    }
}