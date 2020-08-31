package ru.kpp.incidentmanager.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Incident {
    private int id;
    private Timestamp date;
    private int category;
    private int priority;
    private int requesterdepartment;
    private String requester;
    private String requestercontacts;
    private String ipaddress;
    private Integer duration;
    private String description;
    private Integer engineer;
    private int operator;
    private int status;
    private Timestamp closedate;
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
    @Column(name = "REQUESTERDEPARTMENT")
    public int getRequesterdepartment() {
        return requesterdepartment;
    }

    public void setRequesterdepartment(int requesterdepartment) {
        this.requesterdepartment = requesterdepartment;
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
    @Column(name = "REQUESTERCONTACTS")
    public String getRequestercontacts() {
        return requestercontacts;
    }

    public void setRequestercontacts(String requestercontacts) {
        this.requestercontacts = requestercontacts;
    }

    @Basic
    @Column(name = "IPADDRESS")
    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
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
    @Column(name = "CLOSEDATE")
    public Timestamp getClosedate() {
        return closedate;
    }

    public void setClosedate(Timestamp closedate) {
        this.closedate = closedate;
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
        return id == incident.id &&
                category == incident.category &&
                priority == incident.priority &&
                requesterdepartment == incident.requesterdepartment &&
                operator == incident.operator &&
                status == incident.status &&
                Objects.equals(date, incident.date) &&
                Objects.equals(requester, incident.requester) &&
                Objects.equals(requestercontacts, incident.requestercontacts) &&
                Objects.equals(ipaddress, incident.ipaddress) &&
                Objects.equals(duration, incident.duration) &&
                Objects.equals(description, incident.description) &&
                Objects.equals(engineer, incident.engineer) &&
                Objects.equals(closedate, incident.closedate) &&
                Objects.equals(journal, incident.journal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, category, priority, requesterdepartment, requester, requestercontacts, ipaddress, duration, description, engineer, operator, status, closedate, journal);
    }
}
