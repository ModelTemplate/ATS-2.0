# ATS-2.0
Automated Teller System 2.0

Most of source code provided by instructor. Classes that are made from scratch are Withdraw.java, Deposit.java, and BalanceInquiry.java. Made in collaboration with a group.

# How to run / Creating JAR file
First, compile the .java files within the working directory:
> javac ATMCaseStudy.java Account.java ATM.java BalanceInquiry.java BankDatabase.java CashDispenser.java Deposit.java DepositSlot.java Keypad.java Screen.java Transaction.java Withdrawal.java

or

> javac *.java

Then, type the following in command line within the working directory to create a JAR file:
> jar cfm ATS-2.0.jar MANIFEST.txt ATMCaseStudy.class Account.class ATM.class BalanceInquiry.class BankDatabase.class CashDispenser.class Deposit.class DepositSlot.class Keypad.class Screen.class Transaction.class Withdrawal.class

(MANIFEST.txt is needed to tell program where the main method is located)

Finally, run the program:
> java -jar ATS-2.0.jar

# Troubleshooting
Make sure you configure PATH environment variable to use the same JDK version as the one used to compile the code, otherwise the program will not execute.
