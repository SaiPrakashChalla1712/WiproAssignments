package com.java8dateandtimeapi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class DateDifferenceCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            System.out.print("Enter the first date (yyyy-MM-dd): ");
            String firstDateStr = scanner.nextLine();
            LocalDate firstDate = LocalDate.parse(firstDateStr, formatter);

            System.out.print("Enter the second date (yyyy-MM-dd): ");
            String secondDateStr = scanner.nextLine();
            LocalDate secondDate = LocalDate.parse(secondDateStr, formatter);

            long daysBetween = ChronoUnit.DAYS.between(firstDate, secondDate);

            
            System.out.println("Number of days between " + firstDate + " and " + secondDate + " is: " + Math.abs(daysBetween) + " days");

        } catch (Exception e) {
            System.err.println("Invalid date format! Please enter dates in yyyy-MM-dd format.");
        } finally {
            scanner.close();
        }
    }
}

