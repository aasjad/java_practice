package com.librarymanagement.model;

public class Book {
    private final String isbn;
    private final String title;
    private int copiesAvailable;
    private boolean damaged;

    public Book(String isbn, String title, int copiesAvailable, boolean damaged) {
        this.isbn = isbn;
        this.title = title;
        this.copiesAvailable = copiesAvailable;
        this.damaged = damaged;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getCopiesAvailable() {
        return copiesAvailable;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void damage() {
        this.damaged = true;
    }

    public void checkoutCopy() {
        if (copiesAvailable > 0) {
            copiesAvailable--;
        }
    }

    public void returnCopy() {
        copiesAvailable++;
    }
}
