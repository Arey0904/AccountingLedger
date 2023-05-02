package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Reports {

    public static ArrayList<Transaction> transactionsDetail = getTransaction();

    public static ArrayList<Transaction> getTransaction() {
        //Declares a method called getTransactions
        //of the type arrayList that holds transactions objects
        ArrayList<Transaction> transactions = new ArrayList<>();
        //making an array list of transactions object named transactions
        try {
            //creating filereader and bufferreader and passing the transaction.csv file into it.
            FileReader fileReader = new FileReader("transaction.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            //declaring a variable named input of type String
            String input;
            while ((input = bufferedReader.readLine()) != null) {//looping through the csv file
                //taking the current line from the csv file and storing it inside the input variable
                // this loop will keep repeating until the next line is null()
                String[] details = input.split("\\|");//Splitting the input with "|" and storing all the pieces
                //into the String array variable called details
                LocalDate date = LocalDate.parse(details[0]);
                //taking the string at index 0 from the details array and
                //converting it to localDate type using the localDate class and storing it to data variable of variable type LocalDtae
                LocalTime time = LocalTime.parse(details[1]);
                //taking the string at index 1 from detail's array and converting it to
                //and converting it to local time class and storing it to time variable of type Local time
                String description = details[2];
                //taking the string at index 2 from detail's array and converting it to
                //and converting it to string class and storing it to description variable of type String
                String vendor = details[3];
                //taking the string at index 3 from detail's array and converting it to
                //and converting it to string class and storing it to description variable of type String
                double amount = Double.parseDouble(details[4]);
                //taking the string at index 4 from detail's array and converting it to
                //and converting it to string class and storing it to description variable of type Double

                Transaction transaction = new Transaction(date, time, description, vendor, amount);
                //Using the constructor from the transaction class and passing it the (date, time, description)
                //into the constructor to make a new object called transaction of type Transaction
                transactionsDetail.add(transaction);
                //adding the transaction object we just created into the transactions arraylist
                //we will repeat all the steps above for each iteration of the loop(for each line in the csv file)
            }
        } catch (FileNotFoundException e) {//if the csv file can't be found, throw an error
            throw new RuntimeException(e);
        } catch (IOException e) {//if the csv file can't be found, throw an error
            System.out.println("File not found.");
            System.exit(0);
            throw new RuntimeException(e);
        }
        //Sort our transactions ArrayList in ascending order before returning it
        //Collection.sort(transactions, (x , y) -> x.getDate(),compareTo(y.getDate()));
        //getTransaction();
        //transactions.sort(Comparator.comparing(Transaction::getDate).reversed());
        Comparator<Transaction> compareByDate = Comparator.comparing(Transaction::getDate).reversed();
        Comparator<Transaction> compareByTime = Comparator.comparing(Transaction::getTime).reversed();
        Comparator<Transaction> compareByDateTime = compareByDate.thenComparing(compareByTime);
        transactions.stream().sorted(compareByDateTime);
        return transactions;
        // we're returning the transactions array list to our method, so that when we call on our
        //method we get an array list return to us
    }


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

    private static void showSearchByVendor() {
    }

    private static void showPreviousYear() {
    }

    private static void showYearToDate() {
    }

    private static void showPreviousMonth() {
    }

    private static void showMonthToDate() {
    }
}
