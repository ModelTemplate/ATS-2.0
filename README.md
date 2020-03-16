# ATS-2.0
Automated Teller System 2.0

Most of source code provided by instructor. Classes that are made from scratch are Withdraw.java, Deposit.java, and BalanceInquiry.java. Made in collaboration with a group.

# How to run / Creating JAR file
First, compile the .java files within the working directory:
> javac ATMCaseStudy.java Account.java ATM.java BalanceInquiry.java BankDatabase.java CashDispenser.java Deposit.java DepositSlot.java Keypad.java Transaction.java Withdrawal.java

or

> javac *.java

Then, type the following in command line within the working directory:
> jar cfm ATS-2.0.jar MANIFEST.txt ATMCaseStudy.class Account.class ATM.class BalanceInquiry.class BankDatabase.class CashDispenser.class Deposit.class DepositSlot.class Keypad.class Transaction.class Withdrawal.class

Finally, run the program:
> java -jar ATS-2.0.jar
