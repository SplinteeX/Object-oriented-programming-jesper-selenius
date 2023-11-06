package Association;

public class Book {
    private String title;
    private String author;
    private int publicYear;

    public Book(String title, String author, int publicYear) {
        this.title = title;
        this.author = author;
        this.publicYear = publicYear;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getPublicYear() {
        return this.publicYear;
    }

}
