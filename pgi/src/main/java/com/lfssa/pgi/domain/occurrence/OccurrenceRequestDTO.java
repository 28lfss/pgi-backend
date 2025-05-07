package com.lfssa.pgi.domain.occurrence;

import jakarta.validation.constraints.NotNull;

public class OccurrenceRequestDTO {
    @NotNull(message = "Occurrence should have a area")
    public String area;

    @NotNull(message = "Occurrence should have a description")
    public String description;

    @NotNull(message = "Occurrence should have a image path")
    public String imagePath;

    @NotNull(message = "Occurrence should have a registrant ID")
    public long occurrenceRegistrantId;
}
