package incident;

import java.util.Date;

public class Incident {
    private int id;
    private Date incidentDate;
    private String incidentCategory;
    private Priority incidentPriority;
    private String requesterDepartment;
    private String requester;
    private String requesterContacts;
    private String ipAddress;
    private int incidentDuration;
    private String incidentDescription;
    private String executor;
    private String operator;
    private String incidentStatus;
    private Date incidentCloseDate;

    public Incident(String incidentCategory, Priority incidentPriority, String requesterDepartment,
                    String requester, String requesterContacts, String incidentDescription, String operator,
                    String incidentStatus) {
        this.incidentDate = new Date();
        this.incidentCategory = incidentCategory;
        this.incidentPriority = incidentPriority;
        this.requesterDepartment = requesterDepartment;
        this.requester = requester;
        this.requesterContacts = requesterContacts;
        this.incidentDescription = incidentDescription;
        this.operator = operator;
        this.incidentStatus = incidentStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }

    public String getIncidentCategory() {
        return incidentCategory;
    }

    public void setIncidentCategory(String incidentCategory) {
        this.incidentCategory = incidentCategory;
    }

    public Priority getIncidentPriority() {
        return incidentPriority;
    }

    public void setIncidentPriority(Priority incidentPriority) {
        this.incidentPriority = incidentPriority;
    }

    public String getRequesterDepartment() {
        return requesterDepartment;
    }

    public void setRequesterDepartment(String requesterDepartment) {
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

    public int getIncidentDuration() {
        return incidentDuration;
    }

    public void setIncidentDuration(int incidentDuration) {
        this.incidentDuration = incidentDuration;
    }

    public String getIncidentDescription() {
        return incidentDescription;
    }

    public void setIncidentDescription(String incidentDescription) {
        this.incidentDescription = incidentDescription;
    }

    public String getExecutor() {
        return executor;
    }

    public void setExecutor(String executor) {
        this.executor = executor;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getIncidentStatus() {
        return incidentStatus;
    }

    public void setIncidentStatus(String incidentStatus) {
        this.incidentStatus = incidentStatus;
    }

    public Date getIncidentCloseDate() {
        return incidentCloseDate;
    }

    public void setIncidentCloseDate(Date incidentCloseDate) {
        this.incidentCloseDate = incidentCloseDate;
    }
}
