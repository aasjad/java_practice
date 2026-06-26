package com.librarymanagement.exception;

public class UnpaidFinesException extends LibraryException {
    public UnpaidFinesException(String memberId, double amountDue) {
        super("Member has unpaid fines and cannot borrow more books: " + memberId + " (Due: $" + amountDue + ")");
    }
}
