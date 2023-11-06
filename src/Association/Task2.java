package Association;

public class Task2 {
    public static void main(String[] args) {
        Book book1 = new Book("Introduction to Java Programming", "John Smith", 2020);
        Book book2 = new Book("Data Structures and Algorithms", "Jane Doe", 2018);
        Book book3 = new Book("The Art of Fiction", "Alice Johnson", 2019);

        Library2 library = new Library2();

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        library.displayBooks();

        library.borrowBook("Introduction to Java Programming");

        library.displayBooks();

        library.returnBook(book1);

        library.displayBooks();
    }
}
