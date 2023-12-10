package org.example.PreparingTheDatabase.Datasource;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionToDb {
    private static Connection conn = null;

    public static Connection getConnection() {
        if (conn==null) {
            try {
                conn = DriverManager.getConnection(
                        "jdbc:mariadb://localhost:3306/currency_converter_db?user=appuser");
            } catch (SQLException e) {
                System.out.println("Connection failed.");
                e.printStackTrace();
            }
            return conn;
        }
        else {
            return conn;
        }
    }
    public static void Terminate() {
        try {
            getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
