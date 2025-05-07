package com.lfssa.pgi.adapters.outbound.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.JdbcType;
import org.hibernate.dialect.PostgreSQLEnumJdbcType;

@Data
@NoArgsConstructor
@Entity
@Table(name = "occurrences")
public class JpaOccurrenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "occurrence_id", columnDefinition = "serial")
    private long occurrenceId;

    @Column(name = "area")
    private String area;

    @Column(name = "description")
    private String description;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "time_created")
    private long timeCreated;

    @Enumerated(EnumType.STRING)
    @JdbcType(PostgreSQLEnumJdbcType.class)
    @Column(name = "status")
    private Status status;

    @ManyToOne
    @JoinColumn(name = "occurrence_registrant_id", referencedColumnName = "user_id")
    private JpaUserEntity user;

    public enum Status {
        open,
        revision,
        closed
    }
}