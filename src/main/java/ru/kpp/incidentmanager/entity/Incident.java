package ru.kpp.incidentmanager.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;


/**
 * Класс сущности записи об инциденте
 */

@Entity
@Table(schema = "inm")
public class Incident {
    private int id;
    private Timestamp opendate;
    private Category category;
    private Priority priority;
    private Department requesterdepartment;
    private String requester;
    private String requestercontacts;
    private String ipaddress;
    //    private Integer duration;
    private String description;
    private Users engineer;
    private Users operator;
    private Status status;
    private Timestamp closedate;
    private String journal;

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getOpendate() {
        return opendate;
    }

    public void setOpendate(Timestamp opendate) {
        this.opendate = opendate;
    }

    @ManyToOne(targetEntity = Category.class, fetch = FetchType.EAGER)
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @ManyToOne(targetEntity = Priority.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "PRIORITY", columnDefinition = "int default 1")
    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @ManyToOne(targetEntity = Department.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "REQUESTERDEPARTMENT")
    public Department getRequesterdepartment() {
        return requesterdepartment;
    }

    public void setRequesterdepartment(Department requesterdepartment) {
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

//    @Basic
//    @Column(name = "DURATION")
//    public Integer getDuration() {
//        return duration;
//    }
//
//    public void setDuration(Integer duration) {
//        this.duration = duration;
//    }

    @Basic
    @Column(name = "DESCRIPTION", columnDefinition = "TEXT")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToOne(targetEntity = Users.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "ENGINEER")
    public Users getEngineer() {
        return engineer;
    }

    public void setEngineer(Users engineer) {
        this.engineer = engineer;
    }

    @ManyToOne(targetEntity = Users.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "OPERATOR")
    public Users getOperator() {
        return operator;
    }

    public void setOperator(Users operator) {
        this.operator = operator;
    }

    @ManyToOne(targetEntity = Status.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "STATUS", columnDefinition = "int default 1")
    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Basic
    @Column(name = "CLOSEDATE", columnDefinition = "TIMESTAMP")
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
                Objects.equals(opendate, incident.opendate) &&
                Objects.equals(requester, incident.requester) &&
                Objects.equals(requestercontacts, incident.requestercontacts) &&
                Objects.equals(ipaddress, incident.ipaddress) &&
//                Objects.equals(duration, incident.duration) &&
                Objects.equals(description, incident.description) &&
                Objects.equals(engineer, incident.engineer) &&
                Objects.equals(closedate, incident.closedate) &&
                Objects.equals(journal, incident.journal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, opendate, category, priority, requesterdepartment, requester, requestercontacts, ipaddress, /*duration,*/ description, engineer, operator, status, closedate, journal);
    }
}
