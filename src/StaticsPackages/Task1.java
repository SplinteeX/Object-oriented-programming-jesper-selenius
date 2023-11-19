package StaticsPackages;

public class Task1 {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1000);
        BankAccount account2 = new BankAccount(2000);

        account1.deposit(500);
        account2.withdraw(800);

        System.out.println("Account " + account1.getAccountNumber() + " balance: " + account1.getBalance());
        System.out.println("Account " + account2.getAccountNumber() + " balance: " + account2.getBalance());

        System.out.println("Total number of accounts: " + BankAccount.getTotalAccounts());
    }
    public static class BankAccount {
        private int accountNumber;
        private double balance;
        private static int totalAccounts = 0;

        public BankAccount(double initialBalance) {
            balance = initialBalance;
            totalAccounts += 1;
            accountNumber = totalAccounts;
        }
        public void deposit(double deposit) {
            this.balance += deposit;
        }
        public void withdraw(double amount) {
            if (amount <= balance) {
                balance -= amount;
            } else {
                System.out.println("Insufficient funds");
            }
        }
        public double getBalance() {
            return this.balance;
        }
        public int getAccountNumber() {
            return this.accountNumber;
        }
        public static int getTotalAccounts() {
            return totalAccounts;
        }

    }
}
