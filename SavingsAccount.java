public class SavingsAccount extends Account {
    private double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, String ownerName, double initialDeposit) {
        super(accountNumber, ownerName, initialDeposit); // calls Account constructor
        this.interestRate = 0.04; // 4% interest
    }

    // Add interest to balance
    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("Interest of 4% applied: Rs." + interest);
    }
}