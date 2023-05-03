package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.time.YearMonth;
import java.util.*;

public class Reports {

    public static void reportsMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                        
                "Report Entries: 
                [1] Month To Date\n +
                [2] Previous Month\n +
                [3] Year To Date\n +
                [4] Previous Year\n +
                [5] Search by Vendor\n +
                 
                [0] Back - go back to the report page\n +
                [H] Home - go back to the home page""");

        //using switch method instead of if/else statement to run the corresponding method based on the user's input
        String input = scanner.nextLine();
        switch (input.toUpperCase()) {
            case "1":
                showMonthToDate();
                break;
            case "2":
                showPreviousMonth();
                break;
            case "3":
                showYearToDate();
                break;
            case "4":
                showPreviousYear();
            case "5":
                showSearchByVendor();
            case "0":
                Main.reportpage();
            case "H":
                Main.homescreen();
            default:
                System.out.println("Please enter a a valid option");
                break;
        }
    }

    public static void showSearchByVendor() {
        System.out.println("Enter Vendor's Name:");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
    }

    public static int showPreviousYear() {
        Calendar prevYear = Calendar.getInstance();
        prevYear.add(Calendar.YEAR, -1);
        return prevYear.get(Calendar.YEAR);
    }

    public static void showYearToDate() {
        System.out.println("Year To Date Report:");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int year = calendar.get(Calendar.YEAR);
    }

    public static int showPreviousMonth() {
        Calendar prevMonth = Calendar.getInstance();
        prevMonth.add(Calendar.MONTH, -2);
        return prevMonth.get(Calendar.MONTH);
    }

    public static void showMonthToDate() {
        System.out.println("Month To Date Report:");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        int month = calendar.get(Calendar.MONTH);
    }
}
