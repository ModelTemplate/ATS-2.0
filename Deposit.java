package atmcasestudy;

/**
 * Deposit class
 * @author ATS-2.0
 */
public class Deposit extends Transaction {
    private int accountNumber;
    private Screen screen;
    private BankDatabase bankDatabase;
    private Keypad keypad;
    private DepositSlot depositSlot;
    private final int CANCELED = 0;

    public Deposit(int accountNumber, Screen atmScreen, BankDatabase atmDatabase, Keypad atmKeypad, DepositSlot atmDepositSlot) {
        super(accountNumber, atmScreen, atmDatabase);
        this.accountNumber = super.getAccountNumber();
        this.screen = super.getScreen();
        this.bankDatabase = super.getBankDatabase();
        this.keypad = atmKeypad;
        this.depositSlot = atmDepositSlot;
    }

    // overridden, inherited abstract method from superclass
    // executes deposit use case
    public void execute() {
        int depositAmount = this.promptDepositAmount();     // amount in cents
        if (depositAmount != CANCELED) {
            screen.displayMessage("\nPlease insert a deposit envelope containing: ");
            screen.displayDollarAmount(depositAmount / 100);
            screen.displayMessageLine(".");

            if (depositSlot.isEnvelopeReceived()) {
                screen.displayMessageLine("\nYour envelope has been received.");
                screen.displayMessageLine("The money just deposited will not be available until we verify " +
                                            "the amount of any enclosed cash and your checks clear.");
                bankDatabase.credit(this.accountNumber, depositAmount / 100);
            } else {
                screen.displayMessageLine ("\nYou did not insert an envelope. The ATM has canceled your transaction.");
            }
        } else {
            screen.displayMessageLine( "\nCanceling transaction...");
        }
    }

    // returns an int that represents an input from keypad
    private int promptDepositAmount() {
        screen.displayMessage("\nPlease enter a deposit amount in CENTS (or " + CANCELED + " to cancel): ");
        return keypad.getInput();
    }
}
