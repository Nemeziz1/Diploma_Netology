package ru.netology.web.data;
import lombok.Getter;

import java.sql.*;

public class SQL {
    private static final String user = "app";
    private static final String password = "pass";

    @Getter
    private static final String payTable = "payment_gate";
    @Getter
    private static final String creditTable = "credit_gate";

    public static void dropTables() throws SQLException {
        String dropPaymentTables = "DROP TABLE IF EXISTS payment_gate;";
        String dropCreditTables = "DROP TABLE IF EXISTS credit_gate;";
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", user, password);
        Statement statement = connection.createStatement();
        statement.executeUpdate(dropPaymentTables);
        statement.executeUpdate(dropCreditTables);
    }

    public static void createTablePaymentGate() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", user, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE payment_gate (id INT UNIQUE KEY AUTO_INCREMENT, number VARCHAR(19) NOT NULL PRIMARY KEY, status VARCHAR(8) NOT NULL)");
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
    }

    public static void createTableCreditGate() {
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", user, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE credit_gate ( id INT UNIQUE KEY AUTO_INCREMENT, number VARCHAR(19) NOT NULL PRIMARY KEY, status VARCHAR(8) NOT NULL)");
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
    }
    public static void insertApprovedCardPaymentGate() {
        String cardData = "INSERT INTO payment_gate (id, number, status) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(cardData)) {
                preparedStatement.setInt(1, 1);
                preparedStatement.setString(2, "4444 4444 4444 4441");
                preparedStatement.setString(3, "APPROVED");
                int row = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
    }

    public static void insertDeclinedCardPaymentGate() {
        String cardData = "INSERT INTO payment_gate (id, number, status) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(cardData)) {
                preparedStatement.setInt(1,1);
                preparedStatement.setString(2, "4444 4444 4444 4442");
                preparedStatement.setString(3, "DECLINED");
                int row = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
    }

    public static void insertApprovedCardCreditGate() {
        String cardData = "INSERT INTO credit_gate (id, number, status) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(cardData)) {
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2, "4444 4444 4444 4441");
            preparedStatement.setString(3, "APPROVED");
            int row = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
    }

    public static void insertDeclinedCardCreditGate() {
        String cardData = "INSERT INTO credit_gate (id, number, status) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(cardData)) {
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2, "4444 4444 4444 4442");
            preparedStatement.setString(3, "DECLINED");
            int row = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
    }

    //методы для неудачной отправки запроса (из-за некорректно заполненных полей)
    public static void insertEmptyPaymentGateApprovedCard() {
        String cardData = "INSERT INTO payment_gate (id, number, status) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(cardData)) {
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2, "4444 4444 4444 4441");
            preparedStatement.setString(3, "");
            int row = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
    }

    public static void insertEmptyPaymentGateDeclinedCard() {
        String cardData = "INSERT INTO payment_gate (id, number, status) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", user, password);
        PreparedStatement preparedStatement = connection.prepareStatement(cardData)) {
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2, "4444 4444 4444 4442");
            preparedStatement.setString(3, "");
            int row = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
    }

    public static void insertEmptyCreditGateApprovedCard() {
        String cardData = "INSERT INTO credit_gate (id, number, status) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(cardData)) {
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2, "4444 4444 4444 4441");
            preparedStatement.setString(3, "");
            int row = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
    }

    public static void insertEmptyCreditGateDeclinedCard() {
        String cardData = "INSERT INTO credit_gate (id, number, status) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(cardData)) {
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2, "4444 4444 4444 4442");
            preparedStatement.setString(3, "");
            int row = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
    }

    public static void insertEmptyNoCardPaymentGate() {
        String cardData = "INSERT INTO payment_gate (id, number, status) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(cardData)) {
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2, "");
            preparedStatement.setString(3, "");
            int row = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
    }

    public static void insertEmptyNoCardCreditGate() {
        String cardData = "INSERT INTO credit_gate (id, number, status) VALUES (?, ?, ?)";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(cardData)) {
            preparedStatement.setInt(1,1);
            preparedStatement.setString(2, "");
            preparedStatement.setString(3, "");
            int row = preparedStatement.executeUpdate();
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
    }

    //получение статуса
    public static String getCardStatusPaymentGate(String payTable) {
        String status = "";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", user, password);
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT status FROM " + payTable + " ;")) {
                while (resultSet.next()) status = resultSet.getString("status");
            }
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
        return status;
    }

    public static String getCardStatusCreditGate(String creditTable) {
        String status = "";
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", user, password);
             Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT status FROM " + creditTable + " ;")) {
                while (resultSet.next()) status = resultSet.getString("status");
            }
        } catch (SQLException sqlException) {
            sqlException.getErrorCode();
        }
        return status;
    }
}