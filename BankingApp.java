public class BankingApp implements Transaction {

    public void deposit(String accountNumber, double amount) {
        for (BankAccount account : accounts) {
            if (accountNumber.equals(account.getAccountNumber())) {
                account.deposit(amount);
                return;
            }
        }
    }

    public void withdraw(String accountNumber, double amount) {
        for (BankAccount account : accounts) {
            if (accountNumber.equals(account.getAccountNumber())) {
                account.withdraw(amount);
                return;
            }
        }
    }

    public void checkBalance(String accountNumber) {
        for (BankAccount account : accounts) {
            if (accountNumber.equals(account.getAccountNumber())) {
                System.out.println("\n\tCurrent Balance: Rs." + account.getBalance() + "\n");
                return;
            }
        }
    }

    public void addAccount(BankAccount account) {
        accounts.add(account);
    }

    public void accountDetails(String accountNumber) {
        for (BankAccount account : accounts) {
            if (accountNumber.equals(account.getAccountNumber())) {
                System.out.println("\n\nAccount Details: ");
                System.out.println("\tAccount Number:\t\t" + account.getAccountNumber());
                System.out.println("\tAccount Holder:\t\t" + account.getAccountHolder());
                System.out.println("\tAccount Type:\t\t" + account.getAccountType());
                if (account.getAccountType().equals("Saving Account"))
                    System.out.println("\tInterest Rate:\t\t5%");
                else
                    System.out.println("\tOverdraft Limit:\tRs.2000");
                System.out.println("\tBalance: \t\tRs." + account.getBalance() + "\n\n");
                return;
            }
        }
    }

    public boolean validateAccountNumber(String acc) {
        for (BankAccount account : accounts) {
            if (acc.equals(account.getAccountNumber()))
                return true;
        }
        return false;
    }

    public boolean validatePin(String acc, String pin) {
        for (BankAccount account : accounts) {
            if (acc.equals(account.getAccountNumber()) && pin.equals(account.getPin()))
                return true;
        }
        return false;
    }
}
