package main.java.entity;

import java.sql.Timestamp;

public class Incident {
    private int id;
    private Timestamp date;
    private int category;
    private int priority;
    private int requesterDepartment;
    private String requester;
    private String requesterContacts;
    private String ipAddress;
    private int duration;
    private String description;
    private int engineer;
    private int operator;
    private int status;
    private Timestamp closeDate;
    private String journal;
    /**
     * TODO:
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getRequesterDepartment() {
        return requesterDepartment;
    }

    public void setRequesterDepartment(int requesterDepartment) {
        this.requesterDepartment = requesterDepartment;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getRequesterContacts() {
        return requesterContacts;
    }

    public void setRequesterContacts(String requesterContacts) {
        this.requesterContacts = requesterContacts;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEngineer() {
        return engineer;
    }

    public void setEngineer(int engineer) {
        this.engineer = engineer;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Timestamp getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Timestamp closeDate) {
        this.closeDate = closeDate;
    }

    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }
}
