package com.training.banking.model;

import com.training.banking.interfaces.InterestBearing;

public class SavingsAccount extends Account implements InterestBearing {
    private final double minimumBalance;
    private final double interestRate;

    public SavingsAccount(String accountNumber, String holderName, double balance, double minimumBalance, double interestRate) {
        super(accountNumber, holderName, balance);
        this.minimumBalance = minimumBalance;
        this.interestRate = interestRate;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        if (getBalance() - amount < minimumBalance) {
            System.out.println("Withdrawal denied for " + getAccountNumber() + ". Minimum balance must be maintained.");
            return false;
        }
        balance -= amount;
        System.out.println("Withdrew " + amount + " from " + getAccountNumber() + ". New balance: " + balance);
        return true;
    }

    @Override
    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        System.out.println("Interest applied to " + getAccountNumber() + ": " + interest + ". New balance: " + balance);
    }

    @Override
    public void displayDetails() {
        System.out.println("--- Savings Account ---");
        super.displayDetails();
        System.out.println("Minimum Balance: " + minimumBalance);
        System.out.println("Interest Rate: " + (interestRate * 100) + "%\n");
    }
}
