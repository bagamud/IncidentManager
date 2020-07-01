package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity(name = "INCIDENT")
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

    @Id
    @Column(name = "ID", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DATE", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "CATEGORY", nullable = false)
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Basic
    @Column(name = "PRIORITY", nullable = false)
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "REQUESTER_DEPARTMENT", nullable = false)
    public int getRequesterDepartment() {
        return requesterDepartment;
    }

    public void setRequesterDepartment(int requesterDepartment) {
        this.requesterDepartment = requesterDepartment;
    }

    @Basic
    @Column(name = "REQUESTER", nullable = false, length = 255)
    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    @Basic
    @Column(name = "REQUESTER_CONTACTS", nullable = false, length = 45)
    public String getRequesterContacts() {
        return requesterContacts;
    }

    public void setRequesterContacts(String requesterContacts) {
        this.requesterContacts = requesterContacts;
    }

    @Basic
    @Column(name = "IP_ADDRESS", nullable = true, length = 16)
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Basic
    @Column(name = "DURATION", nullable = true)
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "DESCRIPTION", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "ENGINEER", nullable = true)
    public int getEngineer() {
        return engineer;
    }

    public void setEngineer(int engineer) {
        this.engineer = engineer;
    }

    @Basic
    @Column(name = "OPERATOR", nullable = false)
    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "STATUS", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Basic
    @Column(name = "CLOSE_DATE", nullable = true)
    public Timestamp getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Timestamp closeDate) {
        this.closeDate = closeDate;
    }

    @Basic
    @Column(name = "JOURNAL", nullable = true, length = -1)
    public String getJournal() {
        return journal;
    }

    public void setJournal(String journal) {
        this.journal = journal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Incident incident = (Incident) o;
        return id == incident.id &&
                category == incident.category &&
                priority == incident.priority &&
                requesterDepartment == incident.requesterDepartment &&
                duration == incident.duration &&
                engineer == incident.engineer &&
                operator == incident.operator &&
                status == incident.status &&
                Objects.equals(date, incident.date) &&
                Objects.equals(requester, incident.requester) &&
                Objects.equals(requesterContacts, incident.requesterContacts) &&
                Objects.equals(ipAddress, incident.ipAddress) &&
                Objects.equals(description, incident.description) &&
                Objects.equals(closeDate, incident.closeDate) &&
                Objects.equals(journal, incident.journal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, category, priority, requesterDepartment, requester, requesterContacts, ipAddress, duration, description, engineer, operator, status, closeDate, journal);
    }
}
