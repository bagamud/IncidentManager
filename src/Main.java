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
                "ARM/HARDWARE/Printers",
                new Priority(0,1),
                "1 отдел УГИБДД",
                "Филиппов Дмитрий",
                "182",
                "Не печатает принтер",
                "Гаврилова Н.С.",
                "в работе");

        SQLCon connection = new SQLCon();
        connection.connect();
        st = connection.connect().createStatement();
        st.executeUpdate(incident.writeToSQL());
        rs = st.executeQuery("SELECT MAX(ID) FROM INCIDENT");
        rs.next();
        incident.setId(rs.getInt(1));
        System.out.println(incident.getId());
        connection.disconnect();
    }
}
