package com.librarymanagement;

import com.librarymanagement.exception.LibraryException;
import com.librarymanagement.model.Book;
import com.librarymanagement.model.Member;
import com.librarymanagement.service.LibraryService;

public class LibraryApp {
    public static void main(String[] args) {
        LibraryService service = new LibraryService();

        Book book1 = new Book("978-0134685991", "Effective Java", 1, false);
        Book book2 = new Book("978-0596009205", "Head First Java", 0, false);
        Book book3 = new Book("978-0201633610", "Design Patterns", 1, true);

        Member member1 = new Member("M1001", "Alice", false, 0.0);
        Member member2 = new Member("M1002", "Bob", true, 0.0);
        Member member3 = new Member("M1003", "Charlie", false, 12.50);

        service.addBook(book1);
        service.addBook(book2);
        service.addBook(book3);

        try {
            service.checkoutBook("978-0134685991", member1);
            System.out.println("Checkout successful for Alice.");

            service.checkoutBook("978-0596009205", member1);
        } catch (LibraryException ex) {
            System.err.println("Checkout failed: " + ex.getMessage());
        }

        try {
            service.checkoutBook("978-0201633610", member1);
        } catch (LibraryException ex) {
            System.err.println("Checkout failed: " + ex.getMessage());
        }

        try {
            service.checkoutBook("978-0134685991", member2);
        } catch (LibraryException ex) {
            System.err.println("Checkout failed: " + ex.getMessage());
        }

        try {
            service.checkoutBook("978-0134685991", member3);
        } catch (LibraryException ex) {
            System.err.println("Checkout failed: " + ex.getMessage());
        }
    }
}


/*C:\MCL\Java\java_practice\library_management\src>javac com\librarymanagement\exception\*.java com\librarymanagement\model\*.java com\librarymanagement\service\*.java com\librarymanagement\LibraryApp.java

C:\MCL\Java\java_practice\library_management\src>java com.librarymanagement.LibraryApp */