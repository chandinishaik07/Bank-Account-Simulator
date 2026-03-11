import java.util.ArrayList;

public class Bank {
    private String bankName;
    private ArrayList<SavingsAccount> accounts;
    private int accountCounter;

    // Constructor
    public Bank(String bankName) {
        this.bankName = bankName;
        this.accounts = new ArrayList<>();
        this.accountCounter = 1001;
    }

    // Create new account
    public SavingsAccount createAccount(String ownerName, double initialDeposit) {
        String accountNumber = "ACC" + accountCounter++;
        SavingsAccount newAccount = new SavingsAccount(accountNumber, ownerName, initialDeposit);
        accounts.add(newAccount);
        System.out.println("\nAccount created successfully!");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Owner: " + ownerName);
        return newAccount;
    }

    // Find account by account number
    public SavingsAccount findAccount(String accountNumber) {
        for (SavingsAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        System.out.println("Account not found.");
        return null;
    }

    // List all accounts
    public void listAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return;
        }
        System.out.println("\n--- All Accounts in " + bankName + " ---");
        for (SavingsAccount acc : accounts) {
            System.out.println(acc.getAccountNumber() + " | " + acc.getOwnerName() + " | Balance: Rs." + acc.getBalance());
        }
    }
}