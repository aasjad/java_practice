package com.training.banking.interfaces;

import com.training.banking.model.Account;

public interface Transferable {
    boolean transfer(Account from, Account to, double amount);
}
