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
    private boolean isCashDispensed = false;
    private final static int CANCELED = 6;  // keypad input to cancel withdrawal

    public Withdrawal(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad atmKeypad, CashDispenser atmCashDispenser) {
    	super(userAccountNumber, atmScreen, atmBankDatabase);
        this.keypad = atmKeypad;
        this.dispenser = atmCashDispenser;
    }

    // overridden, inherited abstract method from superclass
    // executes withdrawal use case
    public void execute() {
        screen.displayMessage("\nEnter the amount to withdraw: ");
        int withdrawAmount = keypad.getInput();

        if (withdrawAmount != CANCELED) {
            int availableBalance = bankDataBase.getAvailableBalance(getAccountNumber());
            if (widthdrawAmount <= availableBalance) {
                if (dispenser.isSufficientCashAvailable(withdrawAmount)) {
                    bankDataBase.debit(getAccountNumber(), withdrawAmount);
                    cashDispenser.dispenseCash(withdrawAmount);
                    isCashDispensed = true;
                    screen.displayMessageLine( "\nYour cash has been dispensed. Please take your cash now.");
                } else {
                    screen.displayMessageLine( "\nInsufficient funds available in the ATM.\n\nPlease choose a smaller amount.");
                    execute();
                }
            }
        } else {
            screen.displayMessageLine("\nCanceling transaction...");
        }
    }
}
