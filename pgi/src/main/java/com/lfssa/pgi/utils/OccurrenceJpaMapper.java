package com.lfssa.pgi.utils;

import com.lfssa.pgi.adapters.outbound.entities.JpaOccurrenceEntity;
import com.lfssa.pgi.domain.occurrence.Occurrence;
import com.lfssa.pgi.domain.occurrence.OccurrenceResponseDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OccurrenceJpaMapper {
    Occurrence jpaOccurrenceToOccurrence(JpaOccurrenceEntity occurrenceEntity);

    JpaOccurrenceEntity occurrenceToJpaOccurrence(Occurrence occurrence);

    OccurrenceResponseDTO occurrenceToResponse(Occurrence occurrence);
}
