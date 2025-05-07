package com.lfssa.pgi.domain.user;

import com.lfssa.pgi.domain.occurrence.Occurrence;

import java.util.Set;

public class User {

    private long userId;
    private String username;
    private String email;
    private String hashPassword;
    private String sessionToken;
    private long loginTimestamp;
    private AccessLevel accessLevel;
    private boolean active;
    private String device;

    public enum AccessLevel{
        collab,
        admin
    }

    public User() {}

    public User(long userId, String username, String email, String hashPassword, String sessionToken, long loginTimestamp, AccessLevel accessLevel, boolean active, String device) {
        this.userId = userId;
        this.username = username;
        this.email = email;
        this.hashPassword = hashPassword;
        this.sessionToken = sessionToken;
        this.loginTimestamp = loginTimestamp;
        this.accessLevel = accessLevel;
        this.active = active;
        this.device = device;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public long getLoginTimestamp() {
        return loginTimestamp;
    }

    public void setLoginTimestamp(long loginTimestamp) {
        this.loginTimestamp = loginTimestamp;
    }

    public AccessLevel getAccessLevel() {
        return accessLevel;
    }

    public void setAccessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }
}

