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
public class BalanceInquiry extends Transaction{
    
;
    private int account;
    private Screen screen;
    private BankDatabase database;

    
    public BalanceInquiry(int accountNumber, Screen atmScreen, BankDatabase atmDatabase){
        super(accountNumber, atmScreen,atmDatabase);
        account = accountNumber;
        screen = atmScreen;
        database = atmDatabase;
}

  
    @Override
    public void execute(){
        screen.displayMessage("Your account balance is: ");
        screen.displayDollarAmount(database.getTotalBalance(account));
        
    }
    
}
