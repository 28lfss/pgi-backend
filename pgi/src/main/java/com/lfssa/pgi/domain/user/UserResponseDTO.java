package com.lfssa.pgi.domain.user;

import lombok.Data;

@Data
public class UserResponseDTO {
    private long userId;
    private String username;
    private String email;
    private String sessionToken;
    private User.AccessLevel accessLevel;
}
