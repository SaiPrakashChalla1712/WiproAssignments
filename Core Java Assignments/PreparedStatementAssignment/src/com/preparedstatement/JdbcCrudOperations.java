package com.preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet; // Import ResultSet
import java.sql.SQLException;
import java.util.Scanner;  // Import Scanner

public class JdbcCrudOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Initialize Scanner

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro", "root", "root");

            System.out.print("Enter Employee ID to search: ");
            int empId = scanner.nextInt(); // Get employee ID from user
            scanner.nextLine(); // Consume newline character left by nextInt()

            String selectQuery = "SELECT * FROM Employees WHERE eid = ?"; // Parameterized query

            PreparedStatement pstmt = conn.prepareStatement(selectQuery);
            pstmt.setInt(1, empId); // Set the parameter value

            ResultSet rs = pstmt.executeQuery(); // Execute the query

            if (rs.next()) { // Check if any rows were returned
                System.out.println("Employee found:");
                System.out.println("ID: " + rs.getInt("eid"));
                System.out.println("Name: " + rs.getString("ename"));
                System.out.println("Salary: " + rs.getDouble("salary"));
                // ... print other columns as needed
            } else {
                System.out.println("Employee not found.");
            }

            rs.close(); // Close ResultSet
            pstmt.close(); // Close PreparedStatement
            conn.close(); // Close Connection
            scanner.close(); // Close Scanner

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
