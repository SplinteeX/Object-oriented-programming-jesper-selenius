package Association;

import java.util.ArrayList;

public class Library2 {
    private ArrayList<Book> Books = new ArrayList<>();
    private ArrayList<Book> Borrowed = new ArrayList<>();

    public void addBook(Book book) {
        Books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library catalog:");
        for (int i = 0; i < Books.size(); i++) {
            Book book = Books.get(i);
            System.out.println((i + 1) + ". Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getPublicYear());
        }
    }

    public void findBooksByAuthor(String author) {
        System.out.println("Books by author " + author + ":");
        for (Book book : Books) {
            if (book.getAuthor().equals(author)) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getPublicYear());
            }
        }
    }

    public void borrowBook(String title) {
        for (Book book : Books) {
            if (book.getTitle().equals(title)) {
                System.out.println("Book: Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getPublicYear() + " has been borrowed!");
                Borrowed.add(book);
                Books.remove(book);
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found in the library.");
    }

    public void returnBook(Book book) {
        if (Borrowed.contains(book)) {
            System.out.println("Book: Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getPublicYear() + " has been returned!");
            Borrowed.remove(book);
            Books.add(book);
        } else {
            System.out.println("This book is not currently borrowed from the library.");
        }
    }
}
