package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Incident {
    private int id;
    private Timestamp date;
    private int category;
    private int priority;
    private int requesterDepartment;
    private String requester;
    private String requesterContacts;
    private String ipAddress;
    private Integer duration;
    private String description;
    private Integer engineer;
    private int operator;
    private int status;
    private Timestamp closeDate;
    private String journal;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "DATE")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "CATEGORY")
    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    @Basic
    @Column(name = "PRIORITY")
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Basic
    @Column(name = "REQUESTER_DEPARTMENT")
    public int getRequesterDepartment() {
        return requesterDepartment;
    }

    public void setRequesterDepartment(int requesterDepartment) {
        this.requesterDepartment = requesterDepartment;
    }

    @Basic
    @Column(name = "REQUESTER")
    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    @Basic
    @Column(name = "REQUESTER_CONTACTS")
    public String getRequesterContacts() {
        return requesterContacts;
    }

    public void setRequesterContacts(String requesterContacts) {
        this.requesterContacts = requesterContacts;
    }

    @Basic
    @Column(name = "IP_ADDRESS")
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @Basic
    @Column(name = "DURATION")
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
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
    public Integer getEngineer() {
        return engineer;
    }

    public void setEngineer(Integer engineer) {
        this.engineer = engineer;
    }

    @Basic
    @Column(name = "OPERATOR")
    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    @Basic
    @Column(name = "STATUS")
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
    @Column(name = "JOURNAL")
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

        if (id != incident.id) return false;
        if (category != incident.category) return false;
        if (priority != incident.priority) return false;
        if (requesterDepartment != incident.requesterDepartment) return false;
        if (operator != incident.operator) return false;
        if (status != incident.status) return false;
        if (date != null ? !date.equals(incident.date) : incident.date != null) return false;
        if (requester != null ? !requester.equals(incident.requester) : incident.requester != null) return false;
        if (requesterContacts != null ? !requesterContacts.equals(incident.requesterContacts) : incident.requesterContacts != null)
            return false;
        if (ipAddress != null ? !ipAddress.equals(incident.ipAddress) : incident.ipAddress != null) return false;
        if (duration != null ? !duration.equals(incident.duration) : incident.duration != null) return false;
        if (description != null ? !description.equals(incident.description) : incident.description != null)
            return false;
        if (engineer != null ? !engineer.equals(incident.engineer) : incident.engineer != null) return false;
        if (closeDate != null ? !closeDate.equals(incident.closeDate) : incident.closeDate != null) return false;
        if (journal != null ? !journal.equals(incident.journal) : incident.journal != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + category;
        result = 31 * result + priority;
        result = 31 * result + requesterDepartment;
        result = 31 * result + (requester != null ? requester.hashCode() : 0);
        result = 31 * result + (requesterContacts != null ? requesterContacts.hashCode() : 0);
        result = 31 * result + (ipAddress != null ? ipAddress.hashCode() : 0);
        result = 31 * result + (duration != null ? duration.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (engineer != null ? engineer.hashCode() : 0);
        result = 31 * result + operator;
        result = 31 * result + status;
        result = 31 * result + (closeDate != null ? closeDate.hashCode() : 0);
        result = 31 * result + (journal != null ? journal.hashCode() : 0);
        return result;
    }
}
