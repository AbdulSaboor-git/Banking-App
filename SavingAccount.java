// Subclass of BankAccount
public class SavingAccount extends BankAccount {

    // Additional data member
    double interestRate;

    // Constructor
    public SavingAccount(String accountNumber, String accountHolder, String pin, Double balance, double interestRate) {
        super(accountNumber, "Saving Account", accountHolder, pin, balance);
        this.interestRate = interestRate;

    }

    // Implementing Deposit and Withdraw methods by overriding
    @Override
    public void deposit(double amount) {
        if (amount >= 0) {
            double bal = getBalance();
            bal = bal + amount;
            setBalance(bal);
            System.out.println("\tDeposit successful! \n\tNew Balance: Rs." + getBalance() + "\n");
        } else {
            System.out.println("\tInvalid amount entered! Negative Balance not allowed.\n");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount >= 0) {
            if (getBalance() >= amount) {
                double bal = getBalance();
                bal = bal - amount;
                setBalance(bal);
                System.out.println("\tWithdraw successful! \n\tRemaining Balance: Rs." + getBalance() + "\n");
            }

            else
                System.out.println("\tInsufficient balance!\n");
        } else {
            System.out.println("\tInvalid amount entered! Negative Balance not allowed.\n");
        }
    }

    // Additional method for addition of Interest to account balance
    public void addInterest() {
        double interest = getBalance() * interestRate / 100;
        double bal = getBalance();
        bal = bal + interest;
        setBalance(bal);
        System.out.println("\tInterest added! \n\tNew Balance: Rs." + getBalance() + "\n");
    }

}
