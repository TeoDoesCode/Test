package models;

public class InvestmentAccount extends BankAccount {
    private double minimumBalance;
    private double interest;

    public InvestmentAccount(){
        minimumBalance = 0.0;
        interest = 0.0;
    }

    public InvestmentAccount(int accountNo, String accountName, double minimumBalance, double interest){
        super(accountNo);
        this.minimumBalance = minimumBalance;
        this.interest = interest;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public double getInterest() {
        return interest;
    }

    public void addInvestment(double amount){
        if (amount >= minimumBalance){
            deposit(amount);
            System.out.println("Investment successful");
        } else {
            System.out.println("Your investment is below the minimum balance");
        }
    }

    public void inquireInvestmentValue(){
        double balance = inquireBalance();
        double investmentValue = balance * (1 * interest);
        System.out.println("Your investment value is: "+investmentValue);
    }

    public void closeAccount() {
        double investmentValue = inquireBalance() * (1 * interest);
        if (investmentValue > 0) {
            withdraw(investmentValue);
        }
        super(status = "Closed");
        System.out.println("This account has been closed. Remaining balance has been withdrawn.");
    }

}
