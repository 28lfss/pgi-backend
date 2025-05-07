package com.lfssa.pgi.domain.occurrence;

import com.lfssa.pgi.domain.user.User;
import lombok.Data;

@Data
public class OccurrenceResponseDTO {
    private long occurrenceId;
    private String area;
    private String description;
    private String imagePath;
    private long timeCreated;
    private User user;
}
