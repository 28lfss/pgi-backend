package com.lfssa.pgi.domain.occurrence;

import com.lfssa.pgi.domain.user.User;

public class Occurrence {

    private long occurrenceId;
    private String area;
    private String description;
    private String imagePath;
    private long timeCreated;
    private Status status;
    private User user;

    public enum Status{
        open,
        revision,
        closed
    }

    public Occurrence(long occurrenceId, String area, String description, String imagePath, long timeCreated, Status status, User user) {
        this.occurrenceId = occurrenceId;
        this.area = area;
        this.description = description;
        this.imagePath = imagePath;
        this.timeCreated = timeCreated;
        this.status = status;
        this.user = user;
    }

    public Occurrence() {
    }

    public long getOccurrenceId() {
        return occurrenceId;
    }

    public void setOccurrenceId(long occurrenceId) {
        this.occurrenceId = occurrenceId;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public long getTimeCreated() {
        return timeCreated;
    }

    public void setTimeCreated(long timeCreated) {
        this.timeCreated = timeCreated;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
