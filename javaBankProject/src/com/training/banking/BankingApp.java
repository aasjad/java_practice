package com.training.banking;

import com.training.banking.model.CurrentAccount;
import com.training.banking.model.FixedDepositAccount;
import com.training.banking.model.SavingsAccount;
import com.training.banking.service.BankingService;

public class BankingApp {
    public static void main(String[] args) {
        BankingService service = new BankingService();

        SavingsAccount savings = new SavingsAccount("SA1001", "Alice", 2000.00, 1000.00, 0.04);
        CurrentAccount current = new CurrentAccount("CA2001", "Bob", 500.00, 1000.00);
        FixedDepositAccount fixedDeposit = new FixedDepositAccount("FD3001", "Charlie", 10000.00, 12, 0.05, 0.02);

        service.addAccount(savings);
        service.addAccount(current);
        service.addAccount(fixedDeposit);

        service.displayAllAccounts();

        System.out.println("\n--- Transactions ---");
        savings.deposit(500.00);
        current.deposit(300.00);
        current.withdraw(1200.00);
        savings.withdraw(1600.00);
        fixedDeposit.withdraw(2000.00);

        System.out.println("\n--- Interest Application ---");
        service.applyInterestToAll();

        System.out.println("\n--- Transfer ---");
        service.transfer(savings, current, 200.00);

        System.out.println("\n--- Maturing Fixed Deposit ---");
        fixedDeposit.matureAccount();
        fixedDeposit.withdraw(1000.00);

        service.displayAllAccounts();
    }
}
