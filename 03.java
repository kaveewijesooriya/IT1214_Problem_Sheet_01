class BankAccount {
    private int accountNumber;
    private String accountHolder;
    private double balance;

    public BankAccount(int accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    int getaccountNumber() {
        return accountNumber;
    }

    void setaccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    String getaccountHolder() {
        return accountHolder;
    }

    void setaccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    double getbalance() {
        return balance;
    }

    void setbalance(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws IllegalArgumentException {
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance");
        }
        balance -= amount;
    }
}

class Bank {
    private BankAccount[] bankarray = new BankAccount[5];
    private int accountCount = 0;

    void addAccount(BankAccount account) {
        if (accountCount < bankarray.length) {
            bankarray[accountCount] = account;
            accountCount++;
        } else {
            System.out.println("Bank cannot handle more accounts");
        }
    }

    public void withdrawFromAccount(int accountNumber, double amount) {
        for (int i = 0; i < accountCount; i++) {
            if (bankarray[i].getaccountNumber() == accountNumber) {
                try {
                    bankarray[i].withdraw(amount);
                    System.out.println("Withdrawal successful");
                    return;
                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                    return;
                }
            }
        }
        System.out.println("Account not found");
    }

    public void displayAccounts() {
        System.out.println("Bank Accounts:");
        System.out.println("Account Number  " + "Holder  " + "Balance");
        for (int i = 0; i < accountCount; i++) {
            BankAccount b = bankarray[i];
            System.out.println(b.getaccountNumber() + "  " + b.getaccountHolder() + "  " + b.getbalance());
        }
    }
}

class Main {
    public static void main(String[] args) {
        Bank b1 = new Bank();

        b1.addAccount(new BankAccount(1001, "Alice", 5000.0));
        b1.addAccount(new BankAccount(1002, "Bob", 3000.0));

        b1.withdrawFromAccount(1001, 6000.0); 
        b1.withdrawFromAccount(1002, 1000.0); 
        
        b1.displayAccounts();
    }
}