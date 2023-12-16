package org.example.DatabaseUsageVIAJBDC.DAO;
import org.example.DatabaseUsageVIAJBDC.Datasource.ConnectionToDb;
import java.sql.*;

public class CurrencyDao {

    public double getConversionRateByAbbreviation(String abbreviation) {
        Connection connection = null;
        String sql = "SELECT conversion_rate FROM currency WHERE abbreviation = ?";
        double conversionRate = 0;

        try {
            connection = ConnectionToDb.getConnection();

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, abbreviation);

                try (ResultSet rs = preparedStatement.executeQuery()) {
                    if (rs.next()) {
                        conversionRate = rs.getDouble("conversion_rate");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return conversionRate;
    }

    public boolean isConnectionValid() {
        Connection connection = null;
        boolean isValid = false;

        try {
            connection = ConnectionToDb.getConnection();
            isValid = connection.isValid(5);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionToDb.terminate();
        }

        return isValid;
    }

}
