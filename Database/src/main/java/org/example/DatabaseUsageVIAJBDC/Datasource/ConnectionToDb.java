package org.example.DatabaseUsageVIAJBDC.Datasource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDb {

    private static Connection conn = null;

    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/currency_converter_db?user=appuser&password=password");

                if (conn.isValid(5)) {
                    System.out.println("Connected to the database.");
                } else {
                    throw new SQLException("Database connection is not valid.");
                }
            } catch (SQLException e) {
                System.err.println("Failed to connect to the database.");
                throw e;
            }
        }
        return conn;
    }

    public static void terminate() {
        try {
            getConnection().close();
            System.out.println("Connection terminated.");
        } catch (SQLException e) {
            System.err.println("Error closing the database connection.");
            e.printStackTrace();
        }
    }
}
