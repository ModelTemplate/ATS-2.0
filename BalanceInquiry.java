/**
 * BalanceInquiry class
 * Representing the Check Balances use case where
 * the customer views their bank account balance
 * @author ATS-2.0
 */
public class BalanceInquiry extends Transaction {
    private int account;
    private Screen screen;
    private BankDatabase bankDatabase;

    public BalanceInquiry(int accountNumber, Screen atmScreen, BankDatabase atmDatabase) {
        super(accountNumber, atmScreen,atmDatabase);
        this.account = super.getAccountNumber();
        this.screen = super.getScreen();
        this.bankDatabase = super.getBankDatabase();
    }

    // overridden, inherited abstract method from superclass
    // executes balance inquiry use case
    public void execute() {
        screen.displayMessageLine("\nYour account balance:");
        screen.displayMessage("Available balance: ");
        screen.displayDollarAmount(bankDatabase.getAvailableBalance(this.account));
        screen.displayMessage("\nTotal balance: ");
        screen.displayDollarAmount(bankDatabase.getTotalBalance(this.account));
        screen.displayMessageLine("");
    }
}
