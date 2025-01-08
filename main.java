import java.util.Scanner;

public class ATM {

    private static double balance = 1000.00; // Initial balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        System.out.println("Welcome to the ATM!");

        while (!exit) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Funds");
            System.out.println("3. Withdraw Funds");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositFunds(scanner);
                    break;
                case 3:
                    withdrawFunds(scanner);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }

    private static void checkBalance() {
        System.out.printf("Your current balance is: $%.2f\n", balance);
    }

    private static void depositFunds(Scanner scanner) {
        System.out.println("Enter the amount to deposit:");
        double amount = scanner.nextDouble();

        if (amount > 0) {
            balance += amount;
            System.out.printf("Successfully deposited $%.2f. Your new balance is $%.2f\n", amount, balance);
        } else {
            System.out.println("Invalid deposit amount. Please enter a positive value.");
        }
    }

    private static void withdrawFunds(Scanner scanner) {
        System.out.println("Enter the amount to withdraw:");
        double amount = scanner.nextDouble();

        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.printf("Successfully withdrew $%.2f. Your new balance is $%.2f\n", amount, balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Please enter a smaller amount.");
        } else {
            System.out.println("Invalid withdrawal amount. Please enter a positive value.");
        }
    }
}
