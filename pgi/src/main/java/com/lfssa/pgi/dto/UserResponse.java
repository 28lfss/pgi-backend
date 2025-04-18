package com.lfssa.pgi.dto;

import com.lfssa.pgi.domain.model.User;
import java.util.UUID;

public class UserResponse {
    private UUID user_id;
    private String username;
    private String email;
    private String sessionToken;
    private long loginTimestamp;
    private User.AccessLevel accessLevel;
    private boolean isActive;
    private String device;
}
