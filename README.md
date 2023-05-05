# AccountingLedger
Capstone Project 1 Accounting Ledger App


In this Project I created a CLI application. With this application you can track all financial transactions for a 
business or for personal use. You can see all the transactions in the transactions.csv file. Within this could you are able to do a plethora of functions.

The methods you are able to do within the code are add a deposit, make a payment, and look within your ledger. In the ledger you are also able to Look at all
your entries. You are also able to look at your deposits, payments, and any reports within the ledger. Within the Reports you can see your month to dates which will show you the reports of the 1st current month 
to the current day with the added ability to look back on the previous month with the PreviousMonth method. You are also able to look at the 1st of the current year 
to the current day and the previous year with the previous Year method. You are also able to search the vendor in the reports with the SearchByVendor method. Finally, 
you are also able to go back to home-screen anytime you like. This was done by using multiple classes which each has loops and arrays and a multitude of functions and 
methods within them. 

## Things you can do in Home screen
Add a deposit
Make Payment
Show ledger

## In Show Ledger
All Entries
Show deposits
Show Payments
Reports

## Reports

Show Month to Date

Previous Month

Show Year to Date

Previous Year

Search by Vendor

## Pieces of code

while (true) { // using else/if statement to correspond based on users input if (choice.equalsIgnoreCase("H")) { Main.homescreen(); break; } else if (choice.equalsIgnoreCase("R")) { addDeposit(); break; } else { System.out.println("Please enter a valid option ('H' or 'R'):"); choice = scanner.next(); } }
