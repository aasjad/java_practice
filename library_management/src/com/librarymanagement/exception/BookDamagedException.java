package com.librarymanagement.exception;

public class BookDamagedException extends LibraryException {
    public BookDamagedException(String title) {
        super("Book is damaged beyond lending: " + title);
    }
}
