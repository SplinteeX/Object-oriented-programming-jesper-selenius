package StaticsPackages.Task2.model;
import java.util.*;
public class LibraryMember {
    private String name;
    private int memberId;
    private List<Book> borrowedBooks;
    private List<Book> reservedBooks;

    public LibraryMember(String name, int memberId) {
        this.name = name;
        this.memberId = memberId;
        this.borrowedBooks = new ArrayList<>();
        this.reservedBooks = new ArrayList<>();
    }
    public String getName() {
        return this.name;
    }
    public int getMemberId() {
        return this.memberId;
    }
    public List<Book> getBorrowedBooks() {
        return this.borrowedBooks;
    }
    public void setName(String newName) {
        this.name = newName;
    }
    public void setMemberId(int newMemberId) {
        this.memberId = newMemberId;
    }
    // Task 3
    public void reserveBook(Book book) {
        this.reservedBooks.add(book);
    }

    public void cancelReservation(Book book) {
        this.reservedBooks.remove(book);
    }
    public List<Book> getReservedBooks() {
        return this.reservedBooks;
    }
}
