public class CheckingAccount extends BankAccount {

    double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolder, String pin, Double balance,
            double overdraftLimit) {
        super(accountNumber, "Checking Account", accountHolder, pin, balance);
        this.overdraftLimit = overdraftLimit;
    }

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
            if (getBalance() + overdraftLimit >= amount) {
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
}
