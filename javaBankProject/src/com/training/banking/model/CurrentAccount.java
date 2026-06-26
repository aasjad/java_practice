package com.training.banking.model;

public class CurrentAccount extends Account {
    private final double overdraftLimit;

    public CurrentAccount(String accountNumber, String holderName, double balance, double overdraftLimit) {
        super(accountNumber, holderName, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (getBalance() - amount < -overdraftLimit) {
            System.out.println("Withdrawal denied for " + getAccountNumber() + ". Overdraft limit exceeded.");
            return false;
        }
        balance -= amount;
        System.out.println("Withdrew " + amount + " from " + getAccountNumber() + ". New balance: " + balance);
        return true;
    }

    @Override
    public void displayDetails() {
        System.out.println("--- Current Account ---");
        super.displayDetails();
        System.out.println("Overdraft Limit: " + overdraftLimit + "\n");
    }
}
