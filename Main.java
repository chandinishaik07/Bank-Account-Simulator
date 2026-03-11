import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank("Chandini's Bank");
        SavingsAccount currentAccount = null;

        System.out.println("=============================");
        System.out.println("   Welcome to Chandini's Bank  ");
        System.out.println("=============================");

        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Create New Account");
            System.out.println("2. Login to Account");
            System.out.println("3. List All Accounts");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Enter your name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter initial deposit amount: Rs.");
                    double deposit = scanner.nextDouble();
                    scanner.nextLine();
                    bank.createAccount(name, deposit);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String accNo = scanner.nextLine();
                    currentAccount = bank.findAccount(accNo);
                    if (currentAccount != null) {
                        accountMenu(scanner, currentAccount);
                    }
                    break;

                case 3:
                    bank.listAllAccounts();
                    break;

                case 4:
                    System.out.println("Thank you for using Chandini's Bank. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }

    // Account actions menu
    public static void accountMenu(Scanner scanner, SavingsAccount account) {
        while (true) {
            System.out.println("\n--- ACCOUNT MENU [" + account.getOwnerName() + "] ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Apply Interest");
            System.out.println("6. Back to Main Menu");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: Rs.");
                    double dep = scanner.nextDouble();
                    scanner.nextLine();
                    account.deposit(dep);
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: Rs.");
                    double with = scanner.nextDouble();
                    scanner.nextLine();
                    account.withdraw(with);
                    break;

                case 3:
                    System.out.println("Current Balance: Rs." + account.getBalance());
                    break;

                case 4:
                    account.printHistory();
                    break;

                case 5:
                    account.applyInterest();
                    break;

                case 6:
                    return;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}