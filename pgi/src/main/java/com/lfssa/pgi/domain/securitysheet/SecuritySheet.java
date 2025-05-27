package com.lfssa.pgi.domain.securitysheet;

import com.lfssa.pgi.domain.user.User;

public class SecuritySheet {
    private long securitySheetId;
    private long creationTimestamp;
    private User user;
    private boolean active;
    private String manufacture;
    private String productType;
    private String productName;
    private String fileLink;

    public SecuritySheet() {}

    public SecuritySheet(long securitySheetId, long creationTimestamp, boolean active, String manufacture, String productType, String productName, String fileLink) {
        this.securitySheetId = securitySheetId;
        this.creationTimestamp = creationTimestamp;
        this.active = active;
        this.manufacture = manufacture;
        this.productType = productType;
        this.productName = productName;
        this.fileLink = fileLink;
    }

    public long getSecuritySheetId() {
        return securitySheetId;
    }

    public void setSecuritySheetId(long securitySheetId) {
        this.securitySheetId = securitySheetId;
    }

    public long getCreationTimestamp() {
        return creationTimestamp;
    }

    public void setCreationTimestamp(long creationTimestamp) {
        this.creationTimestamp = creationTimestamp;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getFileLink() {
        return fileLink;
    }

    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }
}
