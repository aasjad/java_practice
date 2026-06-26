package com.librarymanagement.exception;

public class BookUnavailableException extends LibraryException {
    public BookUnavailableException(String title) {
        super("Book is already checked out or no copies are available: " + title);
    }
}
