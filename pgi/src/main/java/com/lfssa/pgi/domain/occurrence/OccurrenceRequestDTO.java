package com.lfssa.pgi.domain.occurrence;

import org.springframework.web.multipart.MultipartFile;

public class OccurrenceRequestDTO {
    public String area;

    public String description;

    public long occurrenceRegistrantId;

    public MultipartFile imageFile;

    public OccurrenceRequestDTO(String area, String description, long occurrenceRegistrantId, MultipartFile imageFile) {
        this.area = area;
        this.description = description;
        this.occurrenceRegistrantId = occurrenceRegistrantId;
        this.imageFile = imageFile;
    }
}
