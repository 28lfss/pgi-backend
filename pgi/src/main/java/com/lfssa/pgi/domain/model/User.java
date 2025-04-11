package com.lfssa.pgi.domain.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document(collection = "users") //Connect to users table on mongoDB
public class User {
    @Id private String id;
    private String userId;
    private String email;
    private String username;
    private String hashedPassword;
    private String sessionToken;
    private long loginTimestamp;
    private int accessLevel;
    private boolean isActive;
    private String device;
}