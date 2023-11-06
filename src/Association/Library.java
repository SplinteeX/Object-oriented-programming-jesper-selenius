package Association;

import java.util.ArrayList;

public class Library {
    private ArrayList<Book> Books = new ArrayList<>();

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
}
