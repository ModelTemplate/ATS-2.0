/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atmcasestudy;

/**
 *
 * @author dx200
 */
public class Deposit extends Transaction {
    private Keypad keypad;
    private DepositSlot depositSlot;    
    private int account;
    private Screen screen;
    private BankDatabase database;
    private double depositAmount;
    
    public Deposit(int userAccountNumber, Screen atmScreen, BankDatabase atmBankDatabase, Keypad keypad, DepositSlot depositSlot){
        super(userAccountNumber, atmScreen,atmBankDatabase);
        this.keypad = keypad;
        this.depositSlot = depositSlot;
        account = userAccountNumber;
        screen = atmScreen;
        database = atmBankDatabase;
                
}
    
    @Override    
    public void execute() {
        screen.displayMessage("Enter the amount to deposit ");
        depositAmount = keypad.getInput();
        depositSlot.isEnvelopeReceived();
        database.credit(account, depositAmount);
        screen.displayMessage("You deposited ");
        screen.displayDollarAmount(depositAmount);
    }
}
