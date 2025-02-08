package com.sqlqueriesusingjdbcassignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UserAuthentication {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/wipro", "root", "root");

            // Create table if it doesn't exist (Good practice)
            String createTableQuery = "CREATE TABLE IF NOT EXISTS User (" +
                    "UserID VARCHAR(255) PRIMARY KEY," +
                    "Password VARCHAR(255)" +
                    ")";
            conn.createStatement().execute(createTableQuery);


            System.out.print("Enter User ID: ");
            String userId = scanner.nextLine();

            System.out.print("Enter Password: ");
            String password = scanner.nextLine();

            String hashedPassword = generateHash(password); // Hash the input password

            // Check if the user exists and the password matches
            String selectQuery = "SELECT * FROM User WHERE UserID = ? AND Password = ?";
            PreparedStatement pstmt = conn.prepareStatement(selectQuery);
            pstmt.setString(1, userId);
            pstmt.setString(2, hashedPassword);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("User access granted.");
            } else {
                System.out.println("Invalid User ID or Password.");
            }

            rs.close();
            pstmt.close();
            conn.close();
            scanner.close();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Method to generate SHA-256 hash of a string
    public static String generateHash(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashBytes = md.digest(password.getBytes());

        // Convert byte array to a hexadecimal string
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}

