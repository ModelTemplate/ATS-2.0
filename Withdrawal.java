package atmcasestudy;

/**
 * Withdrawal class
 * @author ATS-2.0
 */
public class Withdrawal extends Transaction {
    private Keypad keypad;
    private CashDispenser dispenser;
    private int withdrawAmount;
    private int account;
    private Screen screen;
    private BankDatabase database;

    public Withdrawal(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad keypad, CashDispenser cashDispenser) {
    	super(userAccountNumber, atmScreen,atmBankDatabase);
        this.keypad = keypad;
        dispenser = cashDispenser;
        account = userAccountNumber;
        screen = atmScreen;
        database = atmBankDatabase;
    }

    public void execute() {
        screen.displayMessage("Enter the amount to withdraw: ");
        withdrawAmount = keypad.getInput();
        dispenser.dispenseCash(withdrawAmount);
        database.debit(account, withdrawAmount);
        screen.displayMessage("Please take your cash.");
    }
}
