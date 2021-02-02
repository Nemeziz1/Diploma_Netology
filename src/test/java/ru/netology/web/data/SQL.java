package ru.netology.web.data;
import lombok.Getter;

import java.sql.*;

public class SQL {
    private static final String url = System.getProperty("db.url");
    private static final String user = System.getProperty("db.user");
    private static final String password = System.getProperty("db.password");
    private static Connection connection;

    @Getter private static final String payTable = "payment_gate";
    @Getter private static final String creditTable = "credit_gate";

    public static void dropTables() throws SQLException {
        String dropPaymentTables = "DELETE FROM credit_gate;";
        String dropCreditTables = "DELETE FROM payment_gate;";
        Connection connection = DriverManager.getConnection(url, user, password);
        Statement statement = connection.createStatement();
        statement.executeUpdate(dropPaymentTables);
        statement.executeUpdate(dropCreditTables);
        connection.close();
    }

    public static String getCardStatus(String table) {
        String status = "";
        try (Connection connection = DriverManager.getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM " + table + " ORDER BY id DESC LIMIT 1;")) {
                while (resultSet.next()) status = resultSet.getString("status");
            }
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
        return status;
    }
}