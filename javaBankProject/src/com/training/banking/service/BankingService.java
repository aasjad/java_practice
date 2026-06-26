package com.training.banking.service;

import com.training.banking.interfaces.InterestBearing;
import com.training.banking.interfaces.Transferable;
import com.training.banking.model.Account;

import java.util.LinkedHashMap;
import java.util.Map;

public class BankingService implements Transferable {
    private final Map<String, Account> accounts = new LinkedHashMap<>();

    public void addAccount(Account account) {
        accounts.put(account.getAccountNumber(), account);
        System.out.println("Account added: " + account.getAccountNumber());
    }

    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    public boolean transfer(Account from, Account to, double amount) {
        if (from == null || to == null) {
            System.out.println("Transfer failed: source or destination account is missing.");
            return false;
        }
        System.out.println("Attempting transfer of " + amount + " from " + from.getAccountNumber() + " to " + to.getAccountNumber());
        if (!from.withdraw(amount)) {
            System.out.println("Transfer failed: withdrawal from source account failed.");
            return false;
        }
        to.deposit(amount);
        System.out.println("Transfer successful.");
        return true;
    }

    public void applyInterestToAll() {
        for (Account account : accounts.values()) {
            if (account instanceof InterestBearing) {
                ((InterestBearing) account).applyInterest();
            }
        }
    }

    public void displayAllAccounts() {
        System.out.println("\n=== All Accounts ===");
        for (Account account : accounts.values()) {
            account.displayDetails();
        }
    }
}
