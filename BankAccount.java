
public abstract class BankAccount {
    private String accountNumber;
    private String accountType;
    private String pin;
    private String accountHolder;
    private double balance;

    BankAccount(String accountNumber, String accountType, String accountHolder, String pin, double balance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.balance = balance;

    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getPin() {
        return pin;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    abstract void deposit(double amount);

    abstract void withdraw(double amount);

}