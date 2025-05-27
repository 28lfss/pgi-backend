package com.lfssa.pgi.domain.securitysheet;

public class SecuritySheetResponseDTO {
    private long securitySheetId;
    private long creationTimestamp;
    private long registrantId;
    private boolean active;
    private String manufacture;
    private String productType;
    private String productName;
    private String fileLink;

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

    public long getRegistrantId() {
        return registrantId;
    }

    public void setRegistrantId(long registrantId) {
        this.registrantId = registrantId;
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
