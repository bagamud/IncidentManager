package incident;

import java.util.Date;

public class Incident {
    private int id;
    private Date date;
    private String category;
    private Priority priority;
    private String departmentRequester;
    private String requester;
    private String contactsRequester;
    private String ipAddress;
    private int duration;
    private String description;
    private String executor;
    private String operator;
    private String status;
    private Date closeDate;

    public Incident(String category, Priority priority, String departmentRequester,
                    String requester, String contactsRequester, String description, String operator,
                    String status) {
        this.date = new Date();
        this.category = category;
        this.priority = priority;
        this.departmentRequester = departmentRequester;
        this.requester = requester;
        this.contactsRequester = contactsRequester;
        this.description = description;
        this.operator = operator;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public String getDepartmentRequester() {
        return departmentRequester;
    }

    public void setDepartmentRequester(String departmentRequester) {
        this.departmentRequester = departmentRequester;
    }

    public String getRequester() {
        return requester;
    }

    public void setRequester(String requester) {
        this.requester = requester;
    }

    public String getContactsRequester() {
        return contactsRequester;
    }

    public void setContactsRequester(String contactsRequester) {
        this.contactsRequester = contactsRequester;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(Date closeDate) {
        this.closeDate = closeDate;
    }
}
