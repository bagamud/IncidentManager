package entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

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
    private Category categoryByCategory;
    private Priority priorityByPriority;
    private Department departmentByRequesterDepartment;
    private Users usersByEngineer;
    private Users usersByOperator;
    private IncStatus incStatusByStatus;

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
        return id == incident.id &&
                category == incident.category &&
                priority == incident.priority &&
                requesterDepartment == incident.requesterDepartment &&
                operator == incident.operator &&
                status == incident.status &&
                Objects.equals(date, incident.date) &&
                Objects.equals(requester, incident.requester) &&
                Objects.equals(requesterContacts, incident.requesterContacts) &&
                Objects.equals(ipAddress, incident.ipAddress) &&
                Objects.equals(duration, incident.duration) &&
                Objects.equals(description, incident.description) &&
                Objects.equals(engineer, incident.engineer) &&
                Objects.equals(closeDate, incident.closeDate) &&
                Objects.equals(journal, incident.journal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, category, priority, requesterDepartment, requester, requesterContacts, ipAddress, duration, description, engineer, operator, status, closeDate, journal);
    }

    @ManyToOne
    @JoinColumn(name = "CATEGORY", referencedColumnName = "ID", nullable = false)
    public Category getCategoryByCategory() {
        return categoryByCategory;
    }

    public void setCategoryByCategory(Category categoryByCategory) {
        this.categoryByCategory = categoryByCategory;
    }

    @ManyToOne
    @JoinColumn(name = "PRIORITY", referencedColumnName = "ID", nullable = false)
    public Priority getPriorityByPriority() {
        return priorityByPriority;
    }

    public void setPriorityByPriority(Priority priorityByPriority) {
        this.priorityByPriority = priorityByPriority;
    }

    @ManyToOne
    @JoinColumn(name = "REQUESTER_DEPARTMENT", referencedColumnName = "ID", nullable = false)
    public Department getDepartmentByRequesterDepartment() {
        return departmentByRequesterDepartment;
    }

    public void setDepartmentByRequesterDepartment(Department departmentByRequesterDepartment) {
        this.departmentByRequesterDepartment = departmentByRequesterDepartment;
    }

    @ManyToOne
    @JoinColumn(name = "ENGINEER", referencedColumnName = "ID")
    public Users getUsersByEngineer() {
        return usersByEngineer;
    }

    public void setUsersByEngineer(Users usersByEngineer) {
        this.usersByEngineer = usersByEngineer;
    }

    @ManyToOne
    @JoinColumn(name = "OPERATOR", referencedColumnName = "ID", nullable = false)
    public Users getUsersByOperator() {
        return usersByOperator;
    }

    public void setUsersByOperator(Users usersByOperator) {
        this.usersByOperator = usersByOperator;
    }

    @ManyToOne
    @JoinColumn(name = "STATUS", referencedColumnName = "ID", nullable = false)
    public IncStatus getIncStatusByStatus() {
        return incStatusByStatus;
    }

    public void setIncStatusByStatus(IncStatus incStatusByStatus) {
        this.incStatusByStatus = incStatusByStatus;
    }
}
