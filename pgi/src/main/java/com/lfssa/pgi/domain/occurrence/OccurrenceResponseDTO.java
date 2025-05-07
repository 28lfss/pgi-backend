package com.lfssa.pgi.domain.occurrence;

import lombok.Data;

@Data
public class OccurrenceResponseDTO {
    private long occurrenceId;
    private String area;
    private String description;
    private String imagePath;
    private long timeCreated;
    private long registrantId;
}
