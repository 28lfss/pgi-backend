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
    public long securitySheetId;

    @ManyToOne
    @JoinColumn(name = "security_sheet_registrant_id", referencedColumnName = "user_id")
    private JpaUserEntity user;

    @Column(name = "creation_timestamp")
    public long creationTimestamp;

    @Column(name = "active")
    public boolean active;

    @Column(name = "manufacture")
    public String manufacture;

    @Column(name = "product_type")
    public String productType;

    @Column(name = "product_name")
    public String productName;

    @Column(name = "file_link")
    public String fileLink;
}
