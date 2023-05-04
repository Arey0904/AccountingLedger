package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FinanceAccount {
    public static void main(String[] args) {


        homescreen();
    }

    public static void homescreen() {
        Scanner scanner = new Scanner(System.in);
        //Welcomes user and Displays Home screen
        System.out.println("""
                Welcome to your Finance Account."
                Main Menu
                [D] - Add Deposit
                [P] - Make Payment
                [L] - Ledger
                [X] - Exit""");
        // use switch method for options in home screen
        String input = scanner.nextLine();
        switch (input.toUpperCase()) {
            case "D":
                addDeposit();
                break;
            case "P":
                makePayment();
                break;
            case "L":
                showLedger();
                break;
            case "X":
                System.exit(0);
            default:
                System.out.println("Please enter a a valid option");
                break;
        }
    }

    public static void addDeposit() {
        //using Scanner to get user's input and storing it in a corresponding variable
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Date.");
        String date = scanner.nextLine();
        System.out.println("Enter Time: HH:MM:SS");
        String time = scanner.nextLine();
        System.out.println("Enter Description");
        String description = scanner.nextLine();
        System.out.println("Enter Vendor:");
        String vendor = scanner.nextLine();
        System.out.println("Enter Transaction Account.");
        double amount = scanner.nextDouble();

        try {
            //writing the information from the variables into the csv. file
            FileWriter fileWriter = new FileWriter("transactions.csv", true);
            //add bar strings in between the variables
            fileWriter.write("\n" +
                    date + "|" +
                    time + "|" +
                    description + "|" +
                    vendor + "|" +
                    amount
            );
            System.out.println("Deposit added successfully!");
        } catch (IOException e) {
            System.out.println("ERROR inputting date!");
            throw new RuntimeException(e);
        }
        homescreen();
    }

    public static void makePayment() {
        // Using Scanner to get user's input and storing it in the corresponding variable
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Date.");
        String date = scanner.nextLine();
        System.out.println("Enter Time: HH:MM:SS");
        String time = scanner.nextLine();
        System.out.println("Enter Description");
        String description = scanner.nextLine();
        System.out.println("Enter Vendor:");
        String vendor = scanner.nextLine();
        System.out.println("Enter Transaction Account.");
        double amount = scanner.nextDouble();
        //storing the amount as a double type.

        try {
            // using the fileWriter to add the collected data into the csv file
            FileWriter fileWriter = new FileWriter("transactions.csv", true);
            //store all the information with a - sign
            fileWriter.write("\n" +
                    date + "|" +
                    time + "|" +
                    description + "|" +
                    vendor + "|" +
                    amount
            );
            System.out.println("Payment added successfully!");
        } catch (IOException e) { //print an error message when input is wrong
            System.out.println("ERROR inputting date!");
            throw new RuntimeException(e);
        }
        homescreen();

    }

    //Calling showLedger() method from the ledger class
    public static void showLedger() {
        Ledger.ShowLedger();
    }

    public static void reportpage() {
        Reports.reportsMenu();
    }

}
