package StaticsPackages.Task2.system;

import StaticsPackages.Task2.model.Book;
import StaticsPackages.Task2.model.LibraryMember;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Book> books;
    private List<LibraryMember> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        this.books.add(book);
        System.out.println("Book added to the library: " + book.getTitle());
    }

    public void addMember(LibraryMember member) {
        this.members.add(member);
        System.out.println("Member added to the library: " + member.getName());
    }

    public void borrowBook(LibraryMember member, Book book) {
        if (books.contains(book) && !member.getBorrowedBooks().contains(book)) {
            member.getBorrowedBooks().add(book);
            System.out.println(member.getName() + " borrowed " + book.getTitle());
        } else {
            System.out.println("Book not available for borrowing.");
        }
    }

    public void returnBook(LibraryMember member, Book book) {
        if (member.getBorrowedBooks().contains(book)) {
            member.getBorrowedBooks().remove(book);
            System.out.println(member.getName() + " returned " + book.getTitle());
        } else {
            System.out.println("Book not borrowed by " + member.getName());
        }
    }
    // Task 3
    public boolean reserveBook(LibraryMember member, Book book) {
        if (books.contains(book) && !book.isReserved()) {
            book.setReserved(true);
            member.getBorrowedBooks().add(book);
            System.out.println(member.getName() + " reserved " + book.getTitle());
            return true;
        }
        return false;
    }

    public boolean cancelReservation(LibraryMember member, Book book) {
        if (member.getBorrowedBooks().contains(book)) {
            book.setReserved(false);
            member.getBorrowedBooks().remove(book);
            System.out.println(member.getName() + " canceled reservation of " + book.getTitle());
            return true;
        } else {
            return false;
        }
    }

    public List<Book> getReservedBooks(LibraryMember member) {
        List<Book> reservedBooks = new ArrayList<>();
        for (Book book : member.getBorrowedBooks()) {
            if (book.isReserved()) {
                reservedBooks.add(book);
            }
        }
        return reservedBooks;
    }
}
