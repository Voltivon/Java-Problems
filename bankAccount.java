class Main {
  public static void main(String[] args) {
    
  }
  
  public static BankAccount makeBankAccount(String accName, String accNum){
     BankAccount newBankAccount = new BankAccount();
     newBankAccount.accountHolderName = accName;
     newBankAccount.accountNumber = accNum;
     newBankAccount.accountBalance = 0.0;
     return newBankAccount;
  }   
  
  public static void displayAccountInfo(BankAccount currBankAccount){
        System.out.println("Account number      : " + currBankAccount.accountNumber);
        System.out.println("Account holder name : " + currBankAccount.accountHolderName);
        System.out.printf("Account Balance     : $%.2f\n", currBankAccount.accountBalance);
  }
  
  public static void chargeServiceFee(BankAccount currBankAccount, double fee){
        currBankAccount.accountBalance = currBankAccount.accountBalance - fee;
  }
  
  public static void applyInterest(BankAccount currBankAccount, double interest){
        double interestRate = interest * currBankAccount.accountBalance;
        currBankAccount.accountBalance = currBankAccount.accountBalance + interestRate;
  }   
  
  public static void payBills(BankAccount currBankAccount, double rent, double utilitesBill, double phoneBill){
     currBankAccount.withdraw(rent);
     currBankAccount.withdraw(utilitesBill);
     currBankAccount.withdraw(phoneBill);
  }
  
  public static void depositChecks(BankAccount currBankAccount, double payCheck, double commissionCheck){
         currBankAccount.deposit(payCheck);
         currBankAccount.deposit(commissionCheck);
}
}

class BankAccount {
    String accountHolderName;
    String accountNumber;
    Double accountBalance;
 
    void deposit(double amount) {
        accountBalance += amount;
        
        System.out.printf("Receipt { $%.2f deposited. New balance is $%.2f }\n", amount, accountBalance);
    }
    
    void withdraw (double amount) {
       accountBalance -= amount;
       
       System.out.printf("Receipt { $%.2f withdrawn. New balance is $%.2f }\n", amount, accountBalance);
    }
}
