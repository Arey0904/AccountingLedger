package org.example;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {
    public static ArrayList<Transaction> transactionsDetail = getTransaction();

    public static ArrayList<Transaction> getTransaction() {
        ArrayList<Transaction> transactions = new ArrayList<>();
        //This method leads transactions objects into transactions array
        try {
            FileReader fileReader = new FileReader("transaction.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String input;
            while ((input = bufferedReader.readLine()) != null) {
                String[] details = input.split("\\|");
                LocalDate date = LocalDate.parse(details[0]);
                LocalTime time = LocalTime.parse(details[1]);
                String description = details[2];
                String vendor = details[3];
                double amount = Double.parseDouble(details[4]);

                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                transactionsDetail.add(transaction);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            System.out.println("File not found.");
            System.exit(0);
            throw new RuntimeException(e);
        }
        getTransaction();
        return transactions;
    }


    public static void ShowLedger() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("""
                Welcome to your Account Ledger."
                Main Menu
                [A] - All Entries
                [D] - Deposits
                [P] - Payments
                [R] - Reports
                [H] - Home""");
        String input = scanner.nextLine();
        switch (input.toUpperCase()) {
            case "A":
                showEntries();
                break;
            case "D":
                showDeposits();
                break;
            case "P":
                showPayments();
                break;
            case "R":
                reportsMenu();
            case "H":
                Main.homescreen();
            default:
                System.out.println("Please enter a a valid option");
                break;
        }

    }

    public static void showEntries() {
        System.out.println("All Entries:");
        for (Transaction item : transactionsDetail) {
            System.out.println(
                    item.getDate() + "  " +
                            item.getTime() + " " +
                            item.getDescription() + " " +
                            item.getVendor() + " " +
                            item.getAmount()
            );
        }

    }

    public static void showDeposits() {

    }

    public static void showPayments() {

    }

    public static void reportsMenu() {

    }
}
