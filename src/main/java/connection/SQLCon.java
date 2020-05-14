package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class SQLCon {
    private final String databaseDriver = "com.mysql.cj.jdbc.Driver";
    private String url;
    private String username;
    private String password;
    private final String maxPool = "250";
    private Connection connection;
    private Properties properties;

    public SQLCon(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    private Properties getProperties() {
        if (properties == null) {
            properties = new Properties();
            properties.setProperty("user", username);
            properties.setProperty("password", password);
            properties.setProperty("MaxPooledStatements", maxPool);
        }
        return properties;
    }

    public Connection connect() {
        if (connection == null) {
            System.out.print("Connecting database...");
            try {
                Class.forName(databaseDriver);
                connection = DriverManager.getConnection(url, username, password);
                System.out.println("OK!");
            } catch (ClassNotFoundException | SQLException e) {
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
