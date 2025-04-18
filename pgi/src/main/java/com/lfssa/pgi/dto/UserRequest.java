package com.lfssa.pgi.dto;

import com.lfssa.pgi.domain.model.User.AccessLevel;

import java.util.UUID;

public class UserRequest {
    public String username;
    public String email;
    public String hashPassword;
    public String sessionToken;
    public long loginTimestamp;
    public AccessLevel accessLevel;
    public boolean isActive;
    public String device;

    public UUID id; //TODO: remove this variable later
}