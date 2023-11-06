package Association;

import java.util.ArrayList;

public class Library4 {
    private ArrayList<Book2> Books = new ArrayList<>();
    private ArrayList<Book2> Borrowed = new ArrayList<Book2>();

    public void addBook(Book2 book) {
        Books.add(book);
    }

    public void displayBooks() {
        System.out.println("Library catalog:");
        for (int i = 0; i < Books.size(); i++) {
            Book2 book = Books.get(i);
            System.out.println((i + 1) + ". Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getPublicYear());
        }
    }

    public void findBooksByAuthor(String author) {
        System.out.println("Books by author " + author + ":");
        for (Book2 book : Books) {
            if (book.getAuthor().equals(author)) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getPublicYear());
            }
        }
    }

    public void borrowBook(String title) {
        for (Book2 book : Books) {
            if (book.getTitle().equals(title)) {
                System.out.println("Book: Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getPublicYear() + " has been borrowed!");
                Borrowed.add(book);
                Books.remove(book);
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found in the library.");
    }

    public void returnBook(Book2 book) {
        if (Borrowed.contains(book)) {
            System.out.println("Book: Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getPublicYear() + " has been returned!");
            Borrowed.remove(book);
            Books.add(book);
        } else {
            System.out.println("This book is not currently borrowed from the library.");
        }
    }

    public boolean isBookAvailable(String title) {
        for (Book2 book : Books) {
            if (book.getTitle().equals(title)) {
                System.out.println("Book " + title + " is available");
                return true;
            }
        }
        System.out.println("Book is not available");
        return false;
    }

    public double getAverageBookRating() {
        int totalRatings = 0;
        int numRatings = 0;

        for (Book2 book : Books) {
            ArrayList<Double> ratings = book.getRatings();
            for (double rating : ratings) {
                totalRatings += rating;
                numRatings++;
            }
        }

        if (numRatings == 0) {
            System.out.println("No ratings found for any book in the library.");
            return 0.0;
        }

        double averageRating = (double) totalRatings / numRatings;
        return averageRating;
    }


    public Book2 getMostReviewedBook() {
        if (Books.isEmpty()) {
            System.out.println("The library is empty, no books to review.");
            return null;
        }

        Book2 mostReviewedBook = null;
        int maxReviews = 0;

        for (Book2 book : Books) {
            ArrayList<String> reviews = book.getReviews();
            int numReviews = reviews.size();

            if (numReviews > maxReviews) {
                maxReviews = numReviews;
                mostReviewedBook = book;
            }
        }
        if (mostReviewedBook != null) {
            return mostReviewedBook;
        } else {
            System.out.println("No reviews found for any book in the library.");
            return null;
        }
    }
}
