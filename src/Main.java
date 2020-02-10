import connection.SQLCon;
import incident.Incident;
import incident.Priority;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) throws SQLException {
        String sql;
        Statement st;
        ResultSet rs;

        Incident incident = new Incident(
                "category",
                new Priority(0,1),
                "1 отдел УГИБДД",
                "Филиппов Дмитрий",
                "182",
                "Не печатает принтер",
                "Гаврилова Н.С.",
                "в работе");

        sql = "INSERT INTO INCIDENT (INCIDENT_DATE, INCIDENT_CATEGORY, INCIDENT_PRIORITY, REQUESTER_DEPARTMENT, " +
                "REQUESTER, REQUESTER_CONTACTS, IP_ADDRESS, INCIDENT_DURATION, INCIDENT_DESCRIPTION, EXECUTOR, " +
                "OPERATOR, INCIDENT_STATUS) VALUES ('" + incident.getIncidentDate() + "', '"
                + incident.getIncidentCategory() + "', '" + incident.getIncidentPriority().getDescription() + "', '"
                + incident.getRequesterDepartment() + "', '" + incident.getRequester() + "', '"
                + incident.getRequesterContacts() + "', '" + incident.getIpAddress() + "', "
                + incident.getIncidentDuration() + ", '" + incident.getIncidentDescription() + "', '"
                + incident.getExecutor() + "', '" + incident.getOperator() + "', '" +
                incident.getIncidentStatus() + "')";

        System.out.println(sql);



        System.out.println(incident.getIncidentDate() + " " + incident.getIncidentPriority().getDescription());
        SQLCon connection = new SQLCon();
        connection.connect();
        st = connection.connect().createStatement();
        st.executeUpdate(sql);


    }
}
