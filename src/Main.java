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

        Incident incident = new Incident("category", new Priority(0,1), "1 отдел УГИБДД",
                "Филиппов Дмитрий", "182", "Не печатает принтер", "Гаврилова Н.С.",
                "в работе");

        sql = "";

        System.out.println(incident.getIncidentDate() + " " + incident.getIncidentPriority().getDescription());
        SQLCon connection = new SQLCon();
        connection.connect();
        st = connection.connect().createStatement();
        st.executeUpdate(sql);


    }
}
