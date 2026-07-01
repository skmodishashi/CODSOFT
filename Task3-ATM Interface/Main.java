import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // creating a sample bank account (in a real system this would come from a database)
        BankAccount account = new BankAccount(101, "Ravi Kumar", 5000.0, "1234");
        ATM atm = new ATM(account);

        System.out.println("=========================================");
        System.out.println("           WELCOME TO JAVA ATM");
        System.out.println("=========================================");

        System.out.print("Enter your 4-digit PIN: ");
        String enteredPin = sc.next();

        int attempts = 1;
        while (!atm.verifyPin(enteredPin) && attempts < 3) {
            System.out.print("Incorrect PIN. Try again: ");
            enteredPin = sc.next();
            attempts++;
        }

        if (!atm.verifyPin(enteredPin)) {
            System.out.println("Too many incorrect attempts. Card blocked. Exiting...");
            sc.close();
            return;
        }

        System.out.println("\nWelcome, " + atm.getAccountHolderName() + "!");

        int choice = 0;

        while (choice != 4) {

            System.out.println("\n----------- ATM MENU -----------");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            // validation for menu choice
            while (!sc.hasNextInt()) {
                System.out.print("Invalid input. Please enter a number between 1 and 4: ");
                sc.next();
            }
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter amount to withdraw: ");
                    while (!sc.hasNextDouble()) {
                        System.out.print("Invalid input. Enter a numeric amount: ");
                        sc.next();
                    }
                    double withdrawAmount = sc.nextDouble();
                    atm.withdraw(withdrawAmount);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    while (!sc.hasNextDouble()) {
                        System.out.print("Invalid input. Enter a numeric amount: ");
                        sc.next();
                    }
                    double depositAmount = sc.nextDouble();
                    atm.deposit(depositAmount);
                    break;

                case 3:
                    atm.checkBalance();
                    break;

                case 4:
                    System.out.println("Thank you for using Java ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please select between 1 and 4.");
            }
        }

        sc.close();
    }
}
