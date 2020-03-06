package atmcasestudy;

/**
 * Withdrawal class
 * @author ATS-2.0
 */
public class Withdrawal extends Transaction {
    // fields inherited from superclass:
    // int accountNumber
    // Screen screen
    // BankDatabase bankDataBase
    private Keypad keypad;
    private CashDispenser dispenser;
    private final int CANCELED = 6;  // keypad input to cancel withdrawal

    public Withdrawal(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, CashDispenser atmCashDispenser) {
    	super(userAccountNumber, atmScreen, atmBankDatabase);
        this.keypad = atmKeypad;
        this.dispenser = atmCashDispenser;
    }

    // overridden, inherited abstract method from superclass
    // executes withdrawal use case
    public void execute() {
        this.displayWithdrawalMenu();
        int withdrawAmount = this.displayMenuOfAmount();

        if (withdrawAmount != CANCELED) {
            int availableBalance = bankDataBase.getAvailableBalance(getAccountNumber());
            if (widthdrawAmount <= availableBalance && dispenser.isSufficientCashAvailable(withdrawAmount)) {
                bankDataBase.debit(getAccountNumber(), withdrawAmount);
                cashDispenser.dispenseCash(withdrawAmount);
                screen.displayMessageLine( "Your cash has been dispensed. Please take your cash now.");
            } else {
                screen.displayMessageLine( "Insufficient funds.\nPlease choose a smaller amount.");
                execute();
            }
        } else {
            screen.displayMessageLine("Canceling transaction...");
        }
    }

    // returns an integer: 20, 40, 60, 100, or 200
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
        screen.displayMessageLine("Withdrawal Menu:");
        screen.displayMessageLine("1 - $20      4 - $100");
        screen.displayMessageLine("2 - $40      5 - $200");
        screen.displayMessageLine("3 - $60      6 - Cancel transaction");
        screen.displayMessageLine("Please choose a withdrawal amount.")
    }
}
