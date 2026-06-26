package com.librarymanagement.exception;

public class BookNotFoundException extends LibraryException {
    public BookNotFoundException(String isbn) {
        super("Book not found in catalogue: " + isbn);
    }
}
