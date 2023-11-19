package StaticsPackages.Task2.model;

public class Book {
    private String title;
    private String author;
    private String isbn;
    // Task3
    private boolean reserved;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        // Task 3
        this.reserved = false;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setTitle(String newTitle) {
        this.title = newTitle;
    }

    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public void setIsbn(String newIsbn) {
        this.isbn = newIsbn;
    }
    // Task 3
    public boolean isReserved() {
        return this.reserved;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

}
