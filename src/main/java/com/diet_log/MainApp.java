package com.diet_log;

import com.diet_log.model.Day;
import com.diet_log.model.Record;
import com.diet_log.model.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:postgresql://localhost:5432/log";
        String username = "postgres";
        String password = "postgres";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            // Establish database connection
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            createTable(connection);
            // Insert records into the database

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        User user = new User("kadri","Kadri2003");
        Day day = new Day(user.getId());
        System.out.println(user);
        Record record = new Record(user.getId(), "Toit", 2,3,4,5,1,2,3);
        Record record2 = new Record(user.getId(), "Toit2", 5,3,4,5,1,2,3);
        day.addRecordToList(record);
        day.addRecordToList(record2);
        System.out.println(record);
        System.out.println(day.dayOverView());
        System.out.println(day.dayOverViewAllRecordsByEnergy());
    }

    private static void createTable(Connection connection) throws SQLException {
        String createTableQuery = "CREATE TABLE IF NOT EXISTS records ("
                + "id SERIAL PRIMARY KEY, "
                + "user_id UUID, "
                + "name VARCHAR(255), "
                + "energy DOUBLE PRECISION, "
                + "fat DOUBLE PRECISION, "
                + "saturated_fat DOUBLE PRECISION, "
                + "carbohydrates DOUBLE PRECISION, "
                + "sugars DOUBLE PRECISION, "
                + "fiber DOUBLE PRECISION, "
                + "protein DOUBLE PRECISION)";

        connection.createStatement().executeUpdate(createTableQuery);
    }
}
