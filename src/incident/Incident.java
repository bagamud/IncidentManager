package incident;

import connection.SQLCon;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Incident {
    private int id;
    private /*Date*/ String incidentDate;
    private String incidentCategory;
    private Priority incidentPriority;
    private String requesterDepartment;
    private String requester;
    private String requesterContacts;
    private String ipAddress;
    private int incidentDuration;
    private String incidentDescription;
    private String engineer;
    private String operator;
    private String incidentStatus;
    private /*Date*/ String incidentCloseDate;
    private SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

    public Incident(String incidentCategory, Priority incidentPriority, String requesterDepartment,
                    String requester, String requesterContacts, String incidentDescription, String operator,
                    String incidentStatus) {
        this.incidentDate = simpleDate.format(new Date());
        this.incidentCategory = incidentCategory;
        this.incidentPriority = incidentPriority;
        this.requesterDepartment = requesterDepartment;
        this.requester = requester;
        this.requesterContacts = requesterContacts;
        this.incidentDescription = incidentDescription;
        this.operator = operator;
        this.incidentStatus = incidentStatus;
    }

    public void writeToSQL(SQLCon connection) throws SQLException {
        Statement st = connection.connect().createStatement();
        st.executeUpdate("INSERT INTO INCIDENT (INCIDENT_DATE, INCIDENT_CATEGORY, INCIDENT_PRIORITY, REQUESTER_DEPARTMENT, " +
                "REQUESTER, REQUESTER_CONTACTS, IP_ADDRESS, INCIDENT_DURATION, INCIDENT_DESCRIPTION, ENGINEER, " +
                "OPERATOR, INCIDENT_STATUS) VALUES ('" + incidentDate + "', '" + incidentCategory + "', '"
                + incidentPriority.getDescription() + "', '" + requesterDepartment + "', '" + requester + "', '"
                + requesterContacts + "', '" + ipAddress + "', " + incidentDuration + ", '" + incidentDescription + "', '"
                + engineer + "', '" + operator + "', '" + incidentStatus + "')");

        ResultSet rs = st.executeQuery("SELECT MAX(ID) FROM INCIDENT");
        rs.next();
        id = rs.getInt(1);
        System.out.println("Зарегистрирована заявка под номером: " + id);
    }

    public void isClosed(Date date) {
        incidentCloseDate = simpleDate.format(date);
        System.out.println("Заявка номер: " + id + " закрыта " + incidentCloseDate);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public /*Date*/ String getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(/*Date*/ String incidentDate) {
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

    public String getEngineer() {
        return engineer;
    }

    public void setEngineer(String engineer) {
        this.engineer = engineer;
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

    public /*Date*/ String getIncidentCloseDate() {
        return incidentCloseDate;
    }

    public void setIncidentCloseDate(/*Date*/ String incidentCloseDate) {
        this.incidentCloseDate = incidentCloseDate;
    }
}
