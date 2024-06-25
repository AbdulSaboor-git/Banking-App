import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static int i = 1113;

    public static void main(String[] args) {
        BankingApp app = new BankingApp();

        // Creating instances of Bank Accounts
        BankAccount account1 = new SavingAccount("HBL1111", "Shabbir", "1111", 24000.0, 5.0);
        BankAccount account2 = new CheckingAccount("HBL1112", "Rahman", "2222", 53000.0, 2000.0);

        app.addAccount(account1);
        app.addAccount(account2);

        while (true) {
            System.out.println("\n\n............ WELCOME TO BankingApp ............\n");
            System.out.println("Select an option bellow:");
            System.out.println("\t1. Access Your Account  \n\t2. Create a New Account \n\t3. Exit");

            Scanner input = new Scanner(System.in);

            try {
                System.out.print("Enter your choice: ");
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        getDetails(app, input);
                        break;
                    case 2:
                        createAccount(app, input);
                        break;
                    case 3:
                        System.out.println("\nExiting...\n\n");
                        System.exit(0);
                    default:
                        System.out.println("\nInvalid choice!");
                        pressToContinue(input);
                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Input! Enter numeric digits only.");
                input.nextLine();
                pressToContinue(input);
            }
        }
    }

    // Account Login
    private static void getDetails(BankingApp app, Scanner input) {

        System.out.print("\nEnter your account number: ");
        String acc = input.nextLine();

        if (app.validateAccountNumber(acc)) {
            System.out.print("Enter your 4 digit PIN: ");

            String pin = inputPin(input);

            if (app.validatePin(acc, pin)) {
                System.out.println("\nSuccessfully Loged In.");
                transactionMenu(acc, app, input);
            } else {
                System.out.println("\nIncorrect PIN!");
                pressToContinue(input);
            }
        } else {
            System.out.println("\nAccount not found!");
            pressToContinue(input);
        }
    }

    // Transaction Menu
    private static void transactionMenu(String acc, BankingApp app, Scanner input) {
        while (true) {
            System.out.println("\n\n............ WELCOME TO BankingApp ............\n");

            System.out.println("Select an option bellow:");
            System.out.println("\t1. Deposit \n\t2. Withdraw \n\t3. Check Balance \n\t4. Account Details \n\t5. Exit");

            try {
                System.out.print("Enter your choice: ");
                int choice = input.nextInt();
                input.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("\n\tEnter amount to deposit: Rs.");
                        double dep = input.nextDouble();
                        input.nextLine();
                        app.deposit(acc, dep);
                        pressToContinue(input);
                        break;
                    case 2:
                        System.out.print("\n\tEnter amount to withdraw: Rs.");
                        double wd = input.nextDouble();
                        input.nextLine();
                        app.withdraw(acc, wd);
                        pressToContinue(input);
                        break;
                    case 3:
                        app.checkBalance(acc);
                        pressToContinue(input);
                        break;
                    case 4:
                        app.accountDetails(acc);
                        pressToContinue(input);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("\nInvalid choice!");
                        pressToContinue(input);

                }
            } catch (InputMismatchException e) {
                System.out.println("\nInvalid Input! Enter numeric digits only.");
                input.nextLine();
                pressToContinue(input);
            }
        }

    }

    // New Account Creation Menu
    private static void createAccount(BankingApp app, Scanner input) {
        System.out.println("\n\n............ Welcome To Account Creation Setup ............\n");

        System.out.println("Enter details below: \n");
        System.out.print("Account Holder Name: ");
        String name = input.nextLine();
        System.out.print("Create a 4 digit PIN: ");
        String pin = inputPin(input);
        String accNum = generateAccNum();
        while (true) {
            System.out.println("Account Type: \n\t1. Saving Account \n\t2. Checking Account");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            if (choice == 1) {
                app.addAccount(new SavingAccount(accNum, name, pin, 0.0, 0.5));
                System.out.println("\nSaving Account with Account Number \"" + accNum
                        + "\" with Interest Rate of 5% created successfully.\n");
                pressToContinue(input);
                return;
            }
            if (choice == 2) {
                app.addAccount(new CheckingAccount(accNum, name, pin, 0.0, 2000));
                System.out.println("\nChecking Account with Account Number \"" + accNum
                        + "\" with Over Draft Limit of Rs.2000 created successfully.\n");
                pressToContinue(input);
                return;
            } else {
                System.out.println("\n\tInvalid choice!");
            }
        }
    }

    // Method for generating account number
    private static String generateAccNum() {

        String accNum = "HBL" + i;
        i++;
        return accNum;
    }

    // Method for getting PIN from user
    private static String inputPin(Scanner input) {
        String pin = "";
        boolean valid = true;
        while (valid) {
            pin = input.nextLine();
            if (pin.matches("\\d{4}"))
                valid = false;
            else {
                System.out.println("\nPlease enter a valid 4 digit PIN.\n");
                System.out.print("Enter PIN again: ");
            }
        }
        return pin;
    }

    // Method for process continuation
    private static void pressToContinue(Scanner input) {
        System.out.print("Press Enter to continue...");
        input.nextLine();
    }
}