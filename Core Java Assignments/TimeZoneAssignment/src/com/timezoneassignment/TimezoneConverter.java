package com.timezoneassignment;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class TimezoneConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        System.out.print("Enter the date and time (format: yyyy-MM-dd HH:mm): ");
        
        String inputDateTimeStr = scanner.nextLine();

        System.out.print("Enter the source timezone (e.g., Asia/Kolkata): ");
        String sourceTimezoneStr = scanner.nextLine();

        System.out.print("Enter the target timezone (e.g., Europe/London): ");
        String targetTimezoneStr = scanner.nextLine();

        try {
            LocalDateTime localDateTime = LocalDateTime.parse(inputDateTimeStr, formatter);

            ZoneId sourceZoneId = ZoneId.of(sourceTimezoneStr);
            ZonedDateTime sourceZonedDateTime = localDateTime.atZone(sourceZoneId);

            ZoneId targetZoneId = ZoneId.of(targetTimezoneStr);
            ZonedDateTime targetZonedDateTime = sourceZonedDateTime.withZoneSameInstant(targetZoneId);

            System.out.println("Source Time:   " + sourceZonedDateTime.format(formatter) + " " + sourceZoneId);
            System.out.println("Converted Time:" + targetZonedDateTime.format(formatter) + " " + targetZoneId);
        } catch (Exception e) {
            System.err.println("An error occurred during conversion: " + e.getMessage());
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}

