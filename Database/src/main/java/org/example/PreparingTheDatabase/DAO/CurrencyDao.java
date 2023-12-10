package org.example.PreparingTheDatabase.DAO;
import org.example.PreparingTheDatabase.Datasource.ConnectionToDb;
import java.sql.*;
import java.util.*;
public class CurrencyDao {
    public double getCurrencyRate(String currencyAbbreviation) {
        double exchangeRate = 0;
        String sql = "SELECT * FROM Currency WHERE abbreviation = ?";
        Connection conn = ConnectionToDb.getConnection();
        try {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(sql);
            exchangeRate = rs.getDouble("conversion_rate");
            System.out.println(exchangeRate);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exchangeRate;

    }
}
