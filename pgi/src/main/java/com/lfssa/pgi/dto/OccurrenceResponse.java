package com.lfssa.pgi.dto;

import com.lfssa.pgi.domain.model.Occurrence;
import lombok.Data;

@Data
public class OccurrenceResponse {
    private long occurrenceId;
    private String area;
    private String description;
    private String imagePath;
    private long timeCreated;
    private Occurrence.Status status;
    private long userId;

    public static OccurrenceResponse from(Occurrence occurrence) {
        OccurrenceResponse response = new OccurrenceResponse();
        response.setOccurrenceId(occurrence.getOccurrenceId());
        response.setArea(occurrence.getArea());
        response.setDescription(occurrence.getDescription());
        response.setImagePath(occurrence.getImagePath());
        response.setTimeCreated(occurrence.getTimeCreated());
        response.setStatus(occurrence.getStatus());
        response.setUserId(occurrence.getUser().getUserId());
        return response;
    }
}
