package com.diet_log;

import com.diet_log.model.Day;
import com.diet_log.model.Record;
import com.diet_log.model.User;

import java.sql.*;
import java.util.Scanner;
import java.util.UUID;

public class MainApp {
    static String jdbcUrl = "jdbc:postgresql://localhost:5432/log";
    static String username = "postgres";
    static String password = "postgres";

    static Connection connection = null;
    static PreparedStatement preparedStatement = null;

    static Scanner scanner = new Scanner(System.in);
    static User activeUser = null;

    public static void main(String[] args) {
        try {
            while (true) {
                connection = DriverManager.getConnection(jdbcUrl, username, password);
                createTables();
                System.out.println("Register(R) or Log in (L):");
                String input = scanner.nextLine().toLowerCase();  // Read user input
                if (input.equals("r")) register();
                else if (input.equals("l")) login();
                else System.out.println("Wrong input!");
            }
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
    }

    private static void register() {
        System.out.println("Username: ");
        String name = scanner.nextLine().toLowerCase();

        System.out.println("Password: ");
        String userpassword = scanner.nextLine().toLowerCase();

        System.out.println("Recommended calorie intake (type NO if not interested): ");
        String recommendedCalorieIntake = scanner.nextLine().toLowerCase();

        User user = null;
        if (!recommendedCalorieIntake.equals("no")) {
            try {
                int calorieIntake = Integer.parseInt(recommendedCalorieIntake);
                user = new User(name, userpassword, calorieIntake);
            } catch (NumberFormatException e) {
                System.out.println("Recommended calorie intake is not a valid integer! Try again.");
                return;
            }
        }else user = new User(name, userpassword);

        addUserToDatabase(user);
        activeUser = user;
        System.out.println("User created: " + user.toString());
    }
    private static void addUserToDatabase(User user) {
        // Assuming you have a "users" table with columns "id", "username", "password", and "calorie_intake"
        String query = "INSERT INTO users (id, name, password, recommended_calorie_intake) VALUES (?, ?, ?, ?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setObject(1, user.getId());
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setInt(4, user.getRecommendedCalorieIntake());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
        }
    }

    private static void login() {
        System.out.println("Username: ");
        String name = scanner.nextLine().toLowerCase();

        System.out.println("Password: ");
        String userpassword = scanner.nextLine().toLowerCase();

        User user = getUserFromDatabase(name, userpassword);

        if (user != null) {
            System.out.println("Login successful!");
            System.out.println("User information: " + user.toString());
            activeUser= user;
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static User getUserFromDatabase(String username, String password) {
        // Assuming you have a "users" table with columns "id", "username", "password", and "calorie_intake"
        String query = "SELECT * FROM users WHERE name = ? AND password = ?";

        try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    UUID id = UUID.fromString(resultSet.getString("id"));
                    int calorieIntake = resultSet.getInt("recommended_calorie_intake");

                    return new User(id, username, password, calorieIntake);
                } else {
                    return null; // User not found
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception according to your application's needs
            return null;
        }
    }

    private static void createTables() throws SQLException {
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

        String createTableQuery2 = "CREATE TABLE IF NOT EXISTS users ("
                + "id UUID PRIMARY KEY, "
                + "name VARCHAR(255), "
                + "password VARCHAR(255), "
                + "recommended_calorie_intake INT)";

        String createTableQuery3 = "CREATE TABLE IF NOT EXISTS day ("
                + "id SERIAL PRIMARY KEY, "
                + "date DATE, "
                + "recordId SERIAL)";

        Statement statement = connection.createStatement();
        statement.executeUpdate(createTableQuery);
        statement.executeUpdate(createTableQuery2);
        statement.executeUpdate(createTableQuery3);
        statement.close();
    }
}
