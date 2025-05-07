package com.lfssa.pgi.application.service;

import com.lfssa.pgi.application.usecases.OccurrenceUseCases;
import com.lfssa.pgi.domain.occurrence.Occurrence;
import com.lfssa.pgi.domain.occurrence.OccurrenceRepository;
import com.lfssa.pgi.domain.user.UserRepository;
import com.lfssa.pgi.domain.occurrence.OccurrenceRequestDTO;
import com.lfssa.pgi.domain.occurrence.OccurrenceResponseDTO;
import com.lfssa.pgi.utils.OccurrenceJpaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OccurrenceServiceImpl implements OccurrenceUseCases {

    @Autowired
    private OccurrenceRepository occurrenceRepository;

    @Autowired
    private OccurrenceJpaMapper occurrenceMapper;

    @Autowired
    private UserRepository userRepository;

    public String createOccurrence(OccurrenceRequestDTO request) {
            Occurrence newOccurrence = new Occurrence();
            newOccurrence.setArea(request.area);
            newOccurrence.setDescription(request.description);
            newOccurrence.setImagePath(request.imagePath);
            newOccurrence.setTimeCreated(System.currentTimeMillis());
            newOccurrence.setStatus(Occurrence.Status.open);
            newOccurrence.setUser(userRepository.findUserById(request.occurrenceRegistrantId).get());

            occurrenceRepository.createOccurrence(newOccurrence);

            //TODO: Change return type
            return "Worked!";

    }

    public List<OccurrenceResponseDTO> findAllOccurrences() {
        return occurrenceRepository.findAllOccurrences().stream().map(occurrenceMapper::occurrenceToResponse).collect(Collectors.toList());
    }
}
