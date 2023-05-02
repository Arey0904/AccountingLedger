package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        homescreen();
    }

    public static void homescreen() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Welcome to your Finance Account."
                Main Menu
                [D] - Add Depost
                [P] - Make Payment
                [L] - LEDGER
                [X] - Exit""");
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
            FileWriter fileWriter = new FileWriter("transaction.csv", true);
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
            FileWriter fileWriter = new FileWriter("transaction.csv", true);
            fileWriter.write("\n" +
                    date + "|" +
                    time + "|" +
                    description + "|" +
                    vendor + "|" +
                    amount
            );
            System.out.println("Payment added successfully!");
        } catch (IOException e) {
            System.out.println("ERROR inputting date!");
            throw new RuntimeException(e);
        }
        homescreen();

    }

    public static void showLedger() {
        Ledger.ShowLedger();
    }

}
