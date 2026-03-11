import java.util.ArrayList;

public class Account {
    private String accountNumber;
    private String ownerName;
    private double balance;
    private ArrayList<String> transactionHistory;

    // Constructor
    public Account(String accountNumber, String ownerName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: Rs." + initialDeposit);
    }

    // Deposit money
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount.");
            return;
        }
        balance += amount;
        transactionHistory.add("Deposited: Rs." + amount);
        System.out.println("Rs." + amount + " deposited successfully.");
    }

    // Withdraw money
    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            balance -= amount;
            transactionHistory.add("Withdrawn: Rs." + amount);
            System.out.println("Rs." + amount + " withdrawn successfully.");
        }
    }

    // Check balance
    public double getBalance() {
        return balance;
    }

    // Print transaction history
    public void printHistory() {
        System.out.println("\n--- Transaction History for " + ownerName + " ---");
        for (String t : transactionHistory) {
            System.out.println(t);
        }
    }

    // Getters
    public String getAccountNumber() { return accountNumber; }
    public String getOwnerName() { return ownerName; }
}