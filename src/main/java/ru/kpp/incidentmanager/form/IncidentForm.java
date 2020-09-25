package ru.kpp.incidentmanager.form;

import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * В данном классе формируется запись об инциденте, стркутурой основанная на классе
 * {@link ru.kpp.incidentmanager.entity.Incident Incident}, и преобразованная
 * для валидации и отображения в веб-форме
 */

public class IncidentForm {
    private int id;
    private Timestamp date;
//    @NotBlank
    private int category;
    private String categoryTitle;
    private int priority;
    private String priorityDescription;
    //    @NotBlank
    private int requesterdepartment;
    private String requesterdepartmentTitle;
    //    @NotBlank
    private String requester;
    //    @NotBlank
    private String requestercontacts;
    private String ipaddress;
    private int duration;
    //    @NotBlank
    private String description;
    private int engineer;
    private String engineerName;
    //    @NotBlank
    private int operator;
    private String operatorName;
    private int status;
    private String statusTitle;
    private Timestamp closedate;
    private String journal;

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

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getPriorityDescription() {
        return priorityDescription;
    }

    public void setPriorityDescription(String priorityDescription) {
        this.priorityDescription = priorityDescription;
    }

    public int getRequesterdepartment() {
        return requesterdepartment;
    }

    public void setRequesterdepartment(int requesterdepartment) {
        this.requesterdepartment = requesterdepartment;
    }

    public String getRequesterdepartmentTitle() {
        return requesterdepartmentTitle;
    }

    public void setRequesterdepartmentTitle(String requesterdepartmentTitle) {
        this.requesterdepartmentTitle = requesterdepartmentTitle;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getRequestercontacts() {
        return requestercontacts;
    }

    public void setRequestercontacts(String requestercontacts) {
        this.requestercontacts = requestercontacts;
    }

    public String getIpaddress() {
        return ipaddress;
    }

    public void setIpaddress(String ipaddress) {
        this.ipaddress = ipaddress;
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

    public String getEngineerName() {
        return engineerName;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }

    public int getOperator() {
        return operator;
    }

    public void setOperator(int operator) {
        this.operator = operator;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusTitle() {
        return statusTitle;
    }

    public void setStatusTitle(String statusTitle) {
        this.statusTitle = statusTitle;
    }

    public Timestamp getClosedate() {
        return closedate;
    }

    public void setClosedate(Timestamp closedate) {
        this.closedate = closedate;
    }

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
        IncidentForm incident = (IncidentForm) o;
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
