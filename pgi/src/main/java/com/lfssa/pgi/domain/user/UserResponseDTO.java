package com.lfssa.pgi.domain.user;

import lombok.Data;

@Data
public class UserResponseDTO {
    private long userId;
    private String username;
    private String email;
    private String sessionToken;
    private User.AccessLevel accessLevel;

    // User mapper that convert to Response
    public static UserResponseDTO from(User user) {
        UserResponseDTO response = new UserResponseDTO();
        response.setUserId(user.getUserId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setSessionToken(user.getSessionToken());
        response.setAccessLevel(user.getAccessLevel());
        return response;
    }
}
