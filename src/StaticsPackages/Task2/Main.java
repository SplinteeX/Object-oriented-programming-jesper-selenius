package StaticsPackages.Task2;

import StaticsPackages.Task2.model.Book;
import StaticsPackages.Task2.model.LibraryMember;
import StaticsPackages.Task2.system.Library;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Book book1 = new Book("Book 1 Title", "Author 1", "ISBN 1");
        Book book2 = new Book("Book 2 Title", "Author 2", "ISBN 2");

        library.addBook(book1);
        library.addBook(book2);

        LibraryMember member1 = new LibraryMember("John Doe", 101);
        LibraryMember member2 = new LibraryMember("Jane Smith", 102);

        library.addMember(member1);
        library.addMember(member2);

        library.borrowBook(member1, book1);
        library.borrowBook(member2, book2);

        library.returnBook(member1, book1);
        library.returnBook(member2, book2);

        // Task 3

        member1.reserveBook(book1);
        member2.reserveBook(book2);

        member1.cancelReservation(book1);

        displayReservedBooks(member1);
        displayReservedBooks(member2);
    }

    private static void displayReservedBooks(LibraryMember member) {
        System.out.println("Reserved books for " + member.getName() + ":");
        List<Book> reservedBooks = member.getReservedBooks();
        if (reservedBooks.isEmpty()) {
            System.out.println("No reserved books.");
        } else {
            for (Book book : reservedBooks) {
                System.out.println("- " + book.getTitle());
            }
        }
        System.out.println();
    }
}
