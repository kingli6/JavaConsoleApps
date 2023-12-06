
public class App {

    public static void main(String[] args) {
        // Testing Savings Account
        SavingsAccount savingsAccount = new SavingsAccount("SA001", 1000.0, 2.5);
        savingsAccount.displayBalance();
        savingsAccount.deposit(500.0);
        savingsAccount.withdraw(200.0);
        savingsAccount.applyInterest();

        // Testing Checking Account
        CheckingAccount checkingAccount = new CheckingAccount("CA001", 1500.0, 500.0);
        checkingAccount.displayBalance();
        checkingAccount.deposit(200.0);
        checkingAccount.withdraw(1800.0); // Exceeds overdraft limit
        checkingAccount.withdraw(300.0);
        checkingAccount.applyInterest(); // No interest for checking accounts
    }
}
