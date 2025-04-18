package com.lfssa.pgi.domain.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID user_id;
    private String username;
    private String email;
    private String hashPassword;
    private String sessionToken;
    private long loginTimestamp;
    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    private AccessLevel accessLevel;
    private boolean isActive;
    private String device;

    public enum AccessLevel{
        COLLAB,
        ADMIN
    }
}

