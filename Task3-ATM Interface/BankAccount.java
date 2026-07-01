public class BankAccount {

    private int accountNumber;
    private String accountHolderName;
    private double balance;
    private String pin;

    public BankAccount(int accountNumber, String accountHolderName, double balance, String pin) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
        this.pin = pin;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public String getPin() {
        return pin;
    }

    // reduce balance, used by withdraw
    public void debit(double amount) {
        balance = balance - amount;
    }

    // increase balance, used by deposit
    public void credit(double amount) {
        balance = balance + amount;
    }
}
