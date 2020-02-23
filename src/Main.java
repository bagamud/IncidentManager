import connection.SQLCon;
import incident.Incident;
import incident.Priority;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
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
        incident.writeToSQL(connection);
        incident.isClosed(connection, 1);
        incident.update(connection, 1);

    }
}
