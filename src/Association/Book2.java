package Association;

import java.util.ArrayList;

public class Book2 {
    private String title;
    private String author;
    private int publicYear;
    private ArrayList<Double> ratings;
    private ArrayList<String> reviews;


    public Book2(String title, String author, int publicYear) {
        this.title = title;
        this.author = author;
        this.publicYear = publicYear;
        this.ratings = new ArrayList<>();
        this.reviews = new ArrayList<>();
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

    public void setRating(double rating) {
        ratings.add(rating);
        System.out.println("Thanks for giving a rating to book " + getTitle() + "!");
    }

    public void addReview(String review) {
        reviews.add(review);
        System.out.println("Thanks for writing review " + getTitle() + "!");
    }

    public ArrayList<Double> getRatings() {
        return ratings;
    }

    public ArrayList<String> getReviews() {
        return reviews;
    }


}
