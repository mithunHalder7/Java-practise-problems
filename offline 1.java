

//Complete the skeleton code
// Write all unfinished code and function


class BankAccount{
    double balance;
    int id;
    // Type of the account. Can be of two types: current or savings
    String accountType;

    // i. Write a Constructor

    BankAccount(double balance,int id,String accountType){

        this.balance=balance;
        this.id=id;
        this.accountType=accountType;
    }

    public BankAccount() {

    }


    // ii. This function increses the balance by amount

    public void deposit(double amount){
        balance=balance+amount;

    }

    // iii. This function decreases the balance by amount

    public void withdraw(double amount){
        if(amount<balance){
            balance=balance-amount;
        }

    }

}




class Bank{

    BankAccount records[];
    double savingInterestRate = 3.5;
    double currentInterestRate = 0.4;
    int index;

    // iv. Write a constructor

    Bank(int size){

       records=new BankAccount[size];

        for(int i=0;i<size;i++)
        {
            records[i] = new BankAccount();
        }

    }

    // v. Complete the function
    public void createBankAccount(double initialBalance, int accountId, String accountType){
        //Create a object of BankAccount class
        BankAccount account = new BankAccount(initialBalance,accountId,accountType);

        // Add the object to records array

        records[index]=account;
        index++;


    }

    // vi. deposit amount to the bank account having id == accountId
    public void addBalance(int accountId, double amount){

        for(int i=0;i<records.length;i++){
            if(accountId==records[i].id){
                records[i].deposit(amount);
            }
        }

    }

    // vii. withdraw amount from the bank account having id == accountId
    public void withdrawBalance(int accountId, double amount){
        for(int i=0;i<records.length;i++){
            if(accountId==records[i].id){
                records[i].withdraw(amount);
            }
        }


    }

    // viii. Calculate intereset for the account having id == accountId
    public double calculateInterest(int accountId, int year){
        double interest=0;
        //formula: balance*interestRate*year
        for(int i=0;i<records.length;i++){
            if(records[i].accountType.equals("saving")){

                interest=records[i].balance*savingInterestRate*year;

            }
            else if(records[i].accountType.equals("current")){
                interest=records[i].balance*currentInterestRate*year;
            }

        }
        return interest;

    }

    // ix. Calculate the total balance for the account having id == accountId

    public double calculateTotalBalance(int accountId, int year){
        double Tbalance=0;

        for(int i=0;i<records.length;i++){
            if(accountId==records[i].id){
                Tbalance=records[i].balance+calculateInterest(accountId,year);

            }
        }
        return Tbalance;
    }

    //Add amount taka bonus to those accounts whose balance > 1000.
    public void addBonus(double amount){
        for(int i=0;i<records.length;i++){
            if(records[i].balance>1000){
                records[i].balance=records[i].balance+amount;
            }
        }

    }

}

 public class TestBank{

    public static void main(String[] args) {
        Bank Rupali = new Bank(1);
        Rupali.createBankAccount(1500,1,"saving");
        Rupali.addBonus(500);


    }
}