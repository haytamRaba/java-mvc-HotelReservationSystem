package com.hotel;

import com.hotel.model.entities.Guest;
import com.hotel.util.DatabaseConnection;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================");
        System.out.println("Hotel Reservation System");
        System.out.println("=================================\n");
        Guest guest = new Guest();

        System.out.println(guest);
        guest.viewRooms();
        // Test database connection
//        System.out.println("Testing database connection...");
//        Connection connection = DatabaseConnection.getConnection();
//
//        if (connection != null) {
//            System.out.println("\n✓ System initialized successfully!");
//            System.out.println("✓ Database is ready");
//            System.out.println("✓ Tables created");
//            System.out.println("✓ Sample data loaded");
//
//            System.out.println("\n=================================");
//            System.out.println("Next steps:");
//            System.out.println("1. Build DAO classes");
//            System.out.println("2. Create Service layer");
//            System.out.println("3. Develop Controllers");
//            System.out.println("4. Design UI Views");
//            System.out.println("=================================");
//        } else {
//            System.err.println("\n✗ System initialization failed!");
//            System.err.println("Check that sqlite-jdbc.jar is properly added to libraries.");
//        }

        // Close connection when done
        DatabaseConnection.closeConnection();
    }
}