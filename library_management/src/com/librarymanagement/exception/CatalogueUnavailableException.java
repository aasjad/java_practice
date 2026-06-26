package com.librarymanagement.exception;

public class CatalogueUnavailableException extends LibraryException {
    public CatalogueUnavailableException(String message, Throwable cause) {
        super("Catalogue database unavailable: " + message, cause);
    }
}
