import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, IOException {
        Config config = new Config();
        Users user = new Users();

//        Incident incident = new Incident(
//                "ARM/HARDWARE/Printers",
//                new Priority(0,1),
//                "1 отдел УГИБДД",
//                "Филиппов Дмитрий",
//                "182",
//                "Не печатает принтер",
//                "Гаврилова Н.С.",
//                "в работе");
//
//        SQLCon connection = new SQLCon(config.getUrl(), config.getUsername(), config.getPassword());
//        incident.writeToSQL(connection);
//        incident.isClosed(connection, 1);
//        incident.update(connection, 1);

    }
}
