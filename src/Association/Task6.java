package Association;

import java.util.ArrayList;

public class Task6 {
    public static void main(String[] args) {
        Library5 library = new Library5();

        Book2 book1 = new Book2("Book1 Title", "Author1", 2000);
        Book2 book2 = new Book2("Book2 Title", "Author2", 1995);
        library.addBook(book1);
        library.addBook(book2);

        User user1 = new User("User1", 25);
        User user2 = new User("User2", 30);
        library.addUser(user1);
        library.addUser(user2);

        library.displayBooks();
        library.displayUsers();

        library.borrowBook("Book1 Title", user1);

        library.isBookAvailable("Book2 Title");

        library.returnBook(book1, user1);

        double averageRating = library.getAverageBookRating();
        System.out.println("Average Book Rating: " + averageRating);

        // Find the most reviewed book
        Book2 mostReviewedBook = library.getMostReviewedBook();
        if (mostReviewedBook != null) {
            System.out.println("Most Reviewed Book: " + mostReviewedBook.getTitle());
        }
    }
}

class User {
    private String name;
    private int age;
    private ArrayList<Book2> borrowedBooks;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
        this.borrowedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public ArrayList<Book2> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void borrowBook(Book2 book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book2 book) {
        borrowedBooks.remove(book);
    }
}

class Library5 {
    private ArrayList<Book2> books = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    public void addBook(Book2 book) {
        books.add(book);
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void displayBooks() {
        System.out.println("Library catalog:");
        for (int i = 0; i < books.size(); i++) {
            Book2 book = books.get(i);
            System.out.println((i + 1) + ". Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getPublicYear());
        }
    }

    public void displayUsers() {
        System.out.println("Library users:");
        for (User user : users) {
            System.out.println("Name: " + user.getName() + ", Age: " + user.getAge());
        }
    }

    public void findBooksByAuthor(String author) {
        System.out.println("Books by author " + author + ":");
        for (Book2 book : books) {
            if (book.getAuthor().equals(author)) {
                System.out.println("Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getPublicYear());
            }
        }
    }

    public void borrowBook(String title, User user) {
        for (Book2 book : books) {
            if (book.getTitle().equals(title)) {
                System.out.println("Book: Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getPublicYear() + " has been borrowed by " + user.getName() + "!");
                user.borrowBook(book);
                books.remove(book);
                return;
            }
        }
        System.out.println("Book with title '" + title + "' not found in the library.");
    }

    public void returnBook(Book2 book, User user) {
        if (user.getBorrowedBooks().contains(book)) {
            System.out.println("Book: Title: " + book.getTitle() + ", Author: " + book.getAuthor() + ", Year: " + book.getPublicYear() + " has been returned by " + user.getName() + "!");
            user.returnBook(book);
            books.add(book);
        } else {
            System.out.println("This book is not currently borrowed by " + user.getName() + " from the library.");
        }
    }

    public boolean isBookAvailable(String title) {
        for (Book2 book : books) {
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

        for (Book2 book : books) {
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
        if (books.isEmpty()) {
            System.out.println("The library is empty, no books to review.");
            return null;
        }

        Book2 mostReviewedBook = null;
        int maxReviews = 0;

        for (Book2 book : books) {
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

