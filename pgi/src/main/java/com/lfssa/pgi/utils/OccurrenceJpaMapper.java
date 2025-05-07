package com.lfssa.pgi.utils;

import com.lfssa.pgi.adapters.outbound.entities.JpaOccurrenceEntity;
import com.lfssa.pgi.domain.occurrence.Occurrence;
import com.lfssa.pgi.domain.occurrence.OccurrenceResponseDTO;
import com.lfssa.pgi.domain.user.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface OccurrenceJpaMapper {
    Occurrence jpaOccurrenceToOccurrence(JpaOccurrenceEntity occurrenceEntity);

    JpaOccurrenceEntity occurrenceToJpaOccurrence(Occurrence occurrence);

    @Mapping(source = "user", target = "registrantId", qualifiedByName = "getRegistrantId")
    OccurrenceResponseDTO occurrenceToResponse(Occurrence occurrence);

    @Named("getRegistrantId")
    public static long getRegistrantId(User user) {
        return user.getUserId();
    }
}
