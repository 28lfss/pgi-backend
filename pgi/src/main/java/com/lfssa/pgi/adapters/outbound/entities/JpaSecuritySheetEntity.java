package com.lfssa.pgi.adapters.outbound.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "security_sheets")
public class JpaSecuritySheetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "security_sheet_id")
    private long securitySheetId;

    @ManyToOne
    @JoinColumn(name = "security_sheet_registrant_id", referencedColumnName = "user_id")
    private JpaUserEntity user;

    @Column(name = "creation_timestamp")
    private long creationTimestamp;

    @Column(name = "active")
    private boolean active;

    @Column(name = "manufacture")
    private String manufacture;

    @Column(name = "product_type")
    private String productType;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "file_link")
    private String fileLink;
}
