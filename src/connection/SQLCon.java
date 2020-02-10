package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLCon {
    private String url = "jdbc:mysql://localhost:3306/incidentManager";
    private String username = "user";
    private String password = "password";
    private Connection connection;

    public Connection connect() {
        if (connection == null) {
            System.out.println("Connecting database...");
            try {
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("Connected!");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }
    public void disconnect() {
        if (connection != null) {
            try {
                connection.close();
                connection = null;
                System.out.println("Database connection closed.");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
