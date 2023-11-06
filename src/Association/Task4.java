package Association;

public class Task4 {
    public static void main(String[] args) {
        Book2 book1 = new Book2("Introduction to Java Programming", "John Smith", 2020);
        book1.setRating(4.5);
        book1.addReview("A comprehensive guide to Java programming."); // Add a review

        Book2 book2 = new Book2("Data Structures and Algorithms", "Jane Doe", 2018);
        book2.setRating(4.0);
        book2.addReview("Great book on data structures and algorithms.");

        Book2 book3 = new Book2("The Art of Fiction", "Alice Johnson", 2019);
        book3.setRating(3.8);
        book3.addReview("A must-read for aspiring fiction writers.");

        Library4 library = new Library4();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayBooks();

        library.borrowBook("Introduction to Java Programming");

        library.displayBooks();

        library.returnBook(book1);

        library.displayBooks();

        String bookTitleToCheck = "Data Structures and Algorithms";
        library.isBookAvailable(bookTitleToCheck);
    }
}
