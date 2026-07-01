public class ATM {

    private BankAccount account;
    private final double minimumBalance = 500.0;   // bank requires this much to always remain in account
    private final double maxWithdrawLimit = 25000.0; // max withdrawal allowed in one transaction

    public ATM(BankAccount account) {
        this.account = account;
    }

    // withdraw money after checking all validations
    public void withdraw(double amount) {

        if (amount <= 0) {
            System.out.println("Transaction failed: Withdrawal amount must be greater than zero.");
            return;
        }

        if (amount % 100 != 0) {
            System.out.println("Transaction failed: Please enter amount in multiples of 100.");
            return;
        }

        if (amount > maxWithdrawLimit) {
            System.out.println("Transaction failed: You cannot withdraw more than " + maxWithdrawLimit + " in a single transaction.");
            return;
        }

        if ((account.getBalance() - amount) < minimumBalance) {
            System.out.println("Transaction failed: Insufficient balance. Minimum balance of " + minimumBalance + " must be maintained.");
            return;
        }

        account.debit(amount);
        System.out.println("Transaction successful! You withdrew " + amount);
        System.out.println("Remaining balance: " + account.getBalance());
    }

    // deposit money into the account
    public void deposit(double amount) {

        if (amount <= 0) {
            System.out.println("Transaction failed: Deposit amount must be greater than zero.");
            return;
        }

        account.credit(amount);
        System.out.println("Transaction successful! You deposited " + amount);
        System.out.println("Updated balance: " + account.getBalance());
    }

    // check and display current balance
    public void checkBalance() {
        System.out.println("Your current balance is: " + account.getBalance());
    }

    // verify pin entered by user before allowing any transaction
    public boolean verifyPin(String enteredPin) {
        return account.getPin().equals(enteredPin);
    }

    public String getAccountHolderName() {
        return account.getAccountHolderName();
    }
}
