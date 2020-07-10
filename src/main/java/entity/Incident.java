package entity;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@JsonAutoDetect
@Entity(name = "INCIDENT")
public class Incident {
    @JsonProperty
    private int id;
    @JsonProperty
    private Timestamp date;
    @JsonProperty
    private int category;
    @JsonProperty
    private int priority;
    @JsonProperty
    private int requesterDepartment;
    @JsonProperty
    private String requester;
    @JsonProperty
    private String requesterContacts;
    @JsonProperty
    private String ipAddress;
    @JsonProperty
    private int duration;
    @JsonProperty
    private String description;
    @JsonProperty
    private int engineer;
    @JsonProperty
    private int operator;
    @JsonProperty
    private int status;
    @JsonProperty
    private Timestamp closeDate;
    @JsonProperty
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
    @Column(name = "REQUESTER", nullable = false)
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
    @Column(name = "IP_ADDRESS", length = 16)
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Basic
    @Column(name = "DURATION")
    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Basic
    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "ENGINEER")
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
    @Column(name = "CLOSE_DATE")
    public Timestamp getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Timestamp closeDate) {
        this.closeDate = closeDate;
    }

    @Basic
    @Column(name = "JOURNAL", length = -1)
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
