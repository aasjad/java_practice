package com.training.banking.model;

import com.training.banking.interfaces.InterestBearing;

public class FixedDepositAccount extends Account implements InterestBearing {
    private final int termInMonths;
    private final double interestRate;
    private final double penaltyRate;
    private boolean matured;

    public FixedDepositAccount(String accountNumber, String holderName, double balance, int termInMonths, double interestRate, double penaltyRate) {
        super(accountNumber, holderName, balance);
        this.termInMonths = termInMonths;
        this.interestRate = interestRate;
        this.penaltyRate = penaltyRate;
        this.matured = false;
    }

    public void matureAccount() {
        this.matured = true;
        System.out.println(getAccountNumber() + " has matured.");
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be positive.");
            return false;
        }
        double totalAmount = amount;
        if (!matured) {
            double penalty = amount * penaltyRate;
            totalAmount += penalty;
            System.out.println("Early withdrawal penalty for " + getAccountNumber() + ": " + penalty);
        }
        if (totalAmount > getBalance()) {
            System.out.println("Withdrawal denied for " + getAccountNumber() + ". Insufficient balance after penalty.");
            return false;
        }
        balance -= totalAmount;
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
        System.out.println("--- Fixed Deposit Account ---");
        super.displayDetails();
        System.out.println("Term (months): " + termInMonths);
        System.out.println("Interest Rate: " + (interestRate * 100) + "%");
        System.out.println("Penalty Rate: " + (penaltyRate * 100) + "%");
        System.out.println("Matured: " + matured + "\n");
    }
}
