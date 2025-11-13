package com.hotel.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class DatabaseConnection {
    private static final String DB_URL = "jdbc:sqlite:hotel.db";
    private static Connection connection = null;

    // Private constructor to prevent instantiation
    private DatabaseConnection() {}

    /**
     * Get database connection (Singleton pattern)
     */
    public static Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                // Load SQLite JDBC driver
                Class.forName("org.sqlite.JDBC");

                // Create connection
                connection = DriverManager.getConnection(DB_URL);

                System.out.println("✓ Database connection established successfully!");

                // Initialize database if needed
                initializeDatabase();
            }
            return connection;
        } catch (ClassNotFoundException e) {
            System.err.println("✗ SQLite JDBC driver not found!");
            System.err.println("Make sure sqlite-jdbc.jar is added to project libraries.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.err.println("✗ Database connection failed!");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Initialize database with schema
     */
    private static void initializeDatabase() {
        try {
            // Read schema.sql from resources
            InputStream inputStream = DatabaseConnection.class
                    .getClassLoader()
                    .getResourceAsStream("database/schema.sql");

            if (inputStream == null) {
                System.err.println("✗ schema.sql not found in resources/database/");
                return;
            }

            String schema = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))
                    .lines()
                    .collect(Collectors.joining("\n"));

            // Execute schema
            Statement statement = connection.createStatement();

            // Split by semicolon and execute each statement
            String[] statements = schema.split(";");
            for (String sql : statements) {
                sql = sql.trim();
                if (!sql.isEmpty()) {
                    statement.execute(sql);
                }
            }

            System.out.println("✓ Database initialized successfully!");
            statement.close();

        } catch (SQLException e) {
            System.err.println("✗ Failed to initialize database!");
            e.printStackTrace();
        }
    }

    /**
     * Close database connection
     */
    public static void closeConnection() {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                System.out.println("✓ Database connection closed.");
            }
        } catch (SQLException e) {
            System.err.println("✗ Failed to close database connection!");
            e.printStackTrace();
        }
    }

    /**
     * Test database connection
     */
    public static boolean testConnection() {
        Connection conn = getConnection();
        return conn != null;
    }
}