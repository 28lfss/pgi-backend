package com.lfssa.pgi.application.service;

import com.lfssa.pgi.domain.model.Occurrence;
import com.lfssa.pgi.domain.repository.OccurrenceRepository;
import com.lfssa.pgi.domain.repository.UserRepository;
import com.lfssa.pgi.dto.OccurrenceRequest;
import com.lfssa.pgi.dto.OccurrenceResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OccurrenceService {

    @Autowired
    private OccurrenceRepository occurrenceRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<String> createOccurrence(OccurrenceRequest request) {
        if (userRepository.existsUserById(request.occurrenceRegistrantId)) {
            Occurrence newOccurrence = new Occurrence();
            newOccurrence.setArea(request.area);
            newOccurrence.setDescription(request.description);
            newOccurrence.setImagePath(request.imagePath);
            newOccurrence.setTimeCreated(System.currentTimeMillis());
            newOccurrence.setUser(userRepository.findUserById(request.occurrenceRegistrantId).get());

            occurrenceRepository.createOccurrence(newOccurrence);

            return new ResponseEntity<>("Occurrence Created", HttpStatus.CREATED);
        }
        //ERROR RESPONSE
        return new ResponseEntity<>("User doesn't exist", HttpStatus.BAD_REQUEST);
    }

    public List<OccurrenceResponse> findAllOccurrences() {
        return occurrenceRepository.findAllOccurrences().stream().map(OccurrenceResponse::from).collect(Collectors.toList());
    }
}
