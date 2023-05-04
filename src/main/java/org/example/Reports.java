package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Year;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

import static org.example.Ledger.transactions;

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

    public static <Transactions> void showSearchByVendor() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" Please enter Vendor's name: ");
        String vendorName = scanner.nextLine();

        for (Transaction item : transactions) {
            if (item.getVendor().equalsIgnoreCase(vendorName)) {
                System.out.println(item.getDate() + " | " + item.getTime() + " | " + item.getDescription() + " | " +
                        item.getVendor() + " | " + item.getAmount());
            }
        }

    }

    public static int showPreviousYear() {
        LocalDate today = LocalDate.now();
        int previousYearValue = today.minusYears(1).getYear(); // changed to get previous year
        System.out.println("Previous Year");
        for (Transaction item : transactions) {
            LocalDate transactionDate = item.getDate();
            if (transactionDate.getYear() == previousYearValue && transactionDate.getYear() != today.getYear()) {
                // changed condition to check if transaction is in previous year
                System.out.println(item.getDate() + " | " + item.getTime() + " | " + item.getDescription() + " | " +
                        item.getVendor() + " | " + item.getAmount());
            }
        }
        return previousYearValue;
    }

    public static void showYearToDate() {// prints the 1st of the current month to the current date(today)
        System.out.println("Here is your year to date report: ");
        LocalDate currentDate = LocalDate.now(); // this method gets the current date using 'LocalDate.now()
        LocalDate startOfTheCurrentYear = currentDate.withDayOfYear(1); // this method gets the first day of the month
        //using the 'withDayOfMonth(1) method
        DateTimeFormatter DateTimeFormatter = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy"); // using the DateTimeFormatter
        //class to format the dates in month to date format
        System.out.println("From" + " " + startOfTheCurrentYear.format(formatter) + " to " + currentDate.format(formatter));

        for (Transaction transaction : transactions) {
            //if we don't subtract 1 , the first day of the month will be excluded since we are using 'isAfter' method
            if (transaction.getDate().isAfter(startOfTheCurrentYear.minusDays(1)) || transaction.getDate().isEqual(currentDate)) {
                System.out.println(transaction.getDate() + " | " + transaction.getTime() + " | " + transaction.getDescription() + " | " +
                        transaction.getVendor() + " | " + transaction.getAmount());
            }
        }
    }

    private static int showPreviousMonth() {
        LocalDate today = LocalDate.now();
        int previousMonthsValue = today.minusMonths(1).getMonthValue();
        System.out.println("Previous months");
        for (Transaction transaction : transactions) {
            LocalDate transactionDate = transaction.getDate();
            if (transactionDate.getMonthValue() == previousMonthsValue && transactionDate.getYear() == today.getYear()) {
                System.out.println(transaction.getTime() + "|" + transaction.getDescription() + "|" + transaction.getVendor() + "|" +
                        transaction.getAmount() + "|" + transaction.getDate());

            }
        }


        return previousMonthsValue;
    }

    private static void showMonthToDate() {// prints the 1st of the current month to the current date(today)
        System.out.println("Here is your month to date report: ");
        LocalDate currentDate = LocalDate.now(); // this method gets the current date using 'LocalDate.now()
        LocalDate startOfTheCurrentMonth = currentDate.withDayOfMonth(1); // this method gets the first day of the month
        //using the 'withDayOfMonth(1) method
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM d, yyyy"); // using the DateTimeFormatter
        //class to format the dates in month to date format
        System.out.println("From" + " " + startOfTheCurrentMonth + " to " + currentDate);

        for (Transaction item : transactions) {
            //if we don't subtract 1 , the first day of the month will be excluded since we are using 'isAfter' method
            if (item.getDate().isAfter(startOfTheCurrentMonth.minusDays(1)) || item.getDate().isEqual(currentDate)) {
                System.out.println(item.getDate() + " | " + item.getTime() + " | " + item.getDescription() + " | " +
                        item.getVendor() + " | " + item.getAmount());
            }
        }
    }
}
