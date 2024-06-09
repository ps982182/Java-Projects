import java.util.Scanner;

public class SimpleBankingApplication {

    // Class to represent a bank account
    static class BankAccount {
        private double balance;

        // Constructor to initialize the account with an initial balance
        public BankAccount(double initialBalance) {
            this.balance = initialBalance;
        }

        // Method to deposit money into the account
        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.printf("Deposited: $%.2f%n", amount);
            } else {
                System.out.println("Invalid deposit amount.");
            }
        }

        // Method to withdraw money from the account
        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.printf("Withdrawn: $%.2f%n", amount);
            } else if (amount > balance) {
                System.out.println("Insufficient funds.");
            } else {
                System.out.println("Invalid withdrawal amount.");
            }
        }

        // Method to check the account balance
        public void checkBalance() {
            System.out.printf("Current balance: $%.2f%n", balance);
        }
    }

    // Main method to run the banking application
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BankAccount account = new BankAccount(0); // Initial balance set to 0

        while (true) {
            // Displaying the menu options
            System.out.println("Banking Application Menu:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            String option = scanner.nextLine();

            // Handling the user's choice
            switch (option) {
                case "1":
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = Double.parseDouble(scanner.nextLine());
                    account.deposit(depositAmount);
                    break;
                case "2":
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = Double.parseDouble(scanner.nextLine());
                    account.withdraw(withdrawAmount);
                    break;
                case "3":
                    account.checkBalance();
                    break;
                case "4":
                    System.out.println("Exiting the application...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose a valid option.");
                    break;
            }
        }
    }
}
