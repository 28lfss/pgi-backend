package com.lfssa.pgi.dto;

import com.lfssa.pgi.domain.model.User;
import lombok.Data;

@Data
public class UserResponse {
    private long userId;
    private String username;
    private String email;
    private String sessionToken;
    private long loginTimestamp;
    private User.AccessLevel accessLevel;
    private boolean active;
    private String device;

    // User mapper that convert to Response
    public static UserResponse from(User user) {
        UserResponse response = new UserResponse();
        response.setUserId(user.getUserId());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setSessionToken(user.getSessionToken());
        response.setLoginTimestamp(user.getLoginTimestamp());
        response.setAccessLevel(user.getAccessLevel());
        response.setActive(user.isActive());
        response.setDevice(user.getDevice());
        return response;
    }
}
