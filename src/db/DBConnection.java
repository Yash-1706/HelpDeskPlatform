package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/helpdesk";
    private static final String USER = "root"; // 🔁 replace with your username
    private static final String PASSWORD = "yash@2006"; // 🔁 replace with your password

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
