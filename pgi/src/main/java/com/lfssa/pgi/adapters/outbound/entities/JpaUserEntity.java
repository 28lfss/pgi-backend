package com.lfssa.pgi.adapters.outbound.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

@Data
@NoArgsConstructor
@Entity
@Table(name = "users")
public class JpaUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long userId;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "hash_password")
    private String hashPassword;

    @Column(name = "session_token")
    private String sessionToken;

    @Column(name = "login_timestamp")
    private long loginTimestamp;

    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(name = "access_level", columnDefinition = "AccessLevel")
    private AccessLevel accessLevel;

    @Column(name = "active")
    private boolean active;

    @Column(name = "device")
    private String device;

    public enum AccessLevel{
        collab,
        admin
    }

}

