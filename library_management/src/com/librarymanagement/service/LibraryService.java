package com.librarymanagement.service;

import com.librarymanagement.exception.BookDamagedException;
import com.librarymanagement.exception.BookNotFoundException;
import com.librarymanagement.exception.BookUnavailableException;
import com.librarymanagement.exception.CatalogueUnavailableException;
import com.librarymanagement.exception.LibraryException;
import com.librarymanagement.exception.MemberCardExpiredException;
import com.librarymanagement.exception.UnpaidFinesException;
import com.librarymanagement.model.Book;
import com.librarymanagement.model.Member;

import java.util.HashMap;
import java.util.Map;

public class LibraryService {
    private final Map<String, Book> catalogue = new HashMap<>();

    public void addBook(Book book) {
        catalogue.put(book.getIsbn(), book);
    }

    public Book findBook(String isbn) throws BookNotFoundException, CatalogueUnavailableException {
        if (catalogue == null) {
            throw new CatalogueUnavailableException("Catalogue service is down", null);
        }
        Book book = catalogue.get(isbn);
        if (book == null) {
            throw new BookNotFoundException(isbn);
        }
        return book;
    }

    public void checkoutBook(String isbn, Member member) throws LibraryException {
        Book book = findBook(isbn);

        if (book.isDamaged()) {
            throw new BookDamagedException(book.getTitle());
        }
        if (book.getCopiesAvailable() == 0) {
            throw new BookUnavailableException(book.getTitle());
        }
        if (member.isCardExpired()) {
            throw new MemberCardExpiredException(member.getMemberId());
        }
        if (member.getUnpaidFines() > 0) {
            throw new UnpaidFinesException(member.getMemberId(), member.getUnpaidFines());
        }

        book.checkoutCopy();
    }
}
