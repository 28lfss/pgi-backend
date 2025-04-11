package com.lfssa.pgi.dto;

import jakarta.validation.constraints.Email;

public class UserRequest {
    public String userId;

    @Email
    public String email;

    public String username;

    public String password;

    public String device;

    public String id;
}