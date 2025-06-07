package com.lfssa.pgi.application.service;

import com.lfssa.pgi.application.usecases.FileStorageUseCases;
import com.lfssa.pgi.application.usecases.OccurrenceUseCases;
import com.lfssa.pgi.domain.occurrence.Occurrence;
import com.lfssa.pgi.domain.occurrence.OccurrenceRepository;
import com.lfssa.pgi.domain.occurrence.OccurrenceRequestDTO;
import com.lfssa.pgi.domain.occurrence.OccurrenceResponseDTO;
import com.lfssa.pgi.domain.user.UserRepository;
import com.lfssa.pgi.infrastructure.config.exceptions.OccurrenceNotFoundException;
import com.lfssa.pgi.infrastructure.config.exceptions.UserNotFoundException;
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

    @Autowired
    private FileStorageUseCases fileStorage;

    public OccurrenceResponseDTO createOccurrence(OccurrenceRequestDTO request) {
        if (!userRepository.existsUserById(request.occurrenceRegistrantId))
            throw new UserNotFoundException("User not found");

        String filePath = fileStorage.store(request.imageFile);

        Occurrence newOccurrence = new Occurrence();
        newOccurrence.setArea(request.area);
        newOccurrence.setDescription(request.description);
        newOccurrence.setImagePath(filePath);
        newOccurrence.setTimeCreated(System.currentTimeMillis());
        newOccurrence.setStatus(Occurrence.Status.open);
        newOccurrence.setUser(userRepository.findUserById(request.occurrenceRegistrantId).get());

        Occurrence response = occurrenceRepository.createOccurrence(newOccurrence);
        return occurrenceMapper.occurrenceToResponse(response);
    }

    public List<OccurrenceResponseDTO> findAllOccurrences() {
        return occurrenceRepository
                .findAllOccurrences()
                .stream()
                .map(occurrenceMapper::occurrenceToResponse)
                .collect(Collectors.toList());
    }

    public List<OccurrenceResponseDTO> FindOccurrencesByUserId(long userId) {
        if (!userRepository.existsUserById(userId)) throw new UserNotFoundException("User not found");

        return occurrenceRepository
                .FindOccurrencesByUser(userRepository.findUserById(userId).get())
                .stream()
                .map(occurrenceMapper::occurrenceToResponse)
                .collect(Collectors.toList());
    }

    public OccurrenceResponseDTO FindOccurrenceById(long occurrenceId) {
        if (!occurrenceRepository.ExistsById(occurrenceId))
            throw new OccurrenceNotFoundException("Occurrence not found");

        return occurrenceMapper.occurrenceToResponse(occurrenceRepository.FindOccurrenceById(occurrenceId));
    }
}
