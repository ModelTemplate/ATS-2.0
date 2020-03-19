/**
 * Withdrawal class
 * Representing the Withdraw Cash use case where
 * the customer takes out money from their bank account
 * @author ATS-2.0
 */
public class Withdrawal extends Transaction {
    private int accountNumber;
    private Screen screen;
    private BankDatabase bankDatabase;
    private Keypad keypad;
    private CashDispenser dispenser;
    private final int CANCELED = 6;  // keypad input to cancel withdrawal

    public Withdrawal(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, CashDispenser atmCashDispenser) {
    	super(userAccountNumber, atmScreen, atmBankDatabase);
        this.accountNumber = super.getAccountNumber();
        this.screen = super.getScreen();
        this.bankDatabase = super.getBankDatabase();
        this.keypad = atmKeypad;
        this.dispenser = atmCashDispenser;
    }

    // overridden, inherited abstract method from superclass
    // executes withdrawal use case
    public void execute() {
        this.displayWithdrawalMenu();
        int withdrawAmount = this.getWithdrawalAmount();

        if (withdrawAmount != CANCELED) {
            double availableBalance = bankDatabase.getAvailableBalance(accountNumber);
            if (withdrawAmount <= availableBalance && dispenser.isSufficientCashAvailable(withdrawAmount)) {
                bankDatabase.debit(getAccountNumber(), withdrawAmount);
                dispenser.dispenseCash(withdrawAmount);
                screen.displayMessageLine( "Your cash has been dispensed. Please take your cash now.");
            } else {
                screen.displayMessageLine( "Insufficient funds.\nPlease choose a smaller amount.");
                execute();
            }
        } else {
            screen.displayMessageLine("Canceling transaction...");
        }
    }

    // returns an integer: 20, 40, 60, 100, or 200 that represents the amount user wants
    // to withdraw from their bank account
    private int getWithdrawalAmount() {
    	int[] amounts = { 20, 40, 60, 100, 200, CANCELED };

        int input = keypad.getInput();
        switch (input) {
            // when the user chose a withdrawal amount
            // chose option 1, 2, 3, 4, or 5
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                return amounts[input - 1];

            default:
                screen.displayMessageLine("Invalid selection. Try again.");
                return getWithdrawalAmount();
        }
    }

    // displays menu of all possible inputs by user for withdrawal
    private void displayWithdrawalMenu() {
        screen.displayMessageLine("\nWithdrawal Menu:");
        screen.displayMessageLine("1 - $20      4 - $100");
        screen.displayMessageLine("2 - $40      5 - $200");
        screen.displayMessageLine("3 - $60      6 - Cancel transaction");
        screen.displayMessageLine("Please choose a withdrawal amount.");
    }
}
