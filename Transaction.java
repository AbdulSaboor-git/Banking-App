import java.util.ArrayList;

public interface Transaction {

    ArrayList<BankAccount> accounts = new ArrayList<>();

    void deposit(String accountNumber, double amount);

    void withdraw(String accountNumber, double amount);

    void checkBalance(String accountNumber);

    void addAccount(BankAccount account);

    void accountDetails(String accountNumber);
}