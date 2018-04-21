package edu.acc.jweb.bookblog2;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
    public int id;
    public String title;
    public String author;
    public String genre;
    public String isbn;
    public Integer rating;
    public String reviewer;
    public String review;
    public Date date;
    
    public Book() {}
            
    public Book (String title, String author, String genre, String isbn, Integer rating, String reviewer, String review) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isbn = isbn;
        this.rating = rating;
        this.review = review;
        this.reviewer = reviewer;
    }
    
    public Integer getId() {
        return this.id;
    }
    public String getTitle() {
        return this.title;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getGenre() {
        return this.genre;
    }
    public String getIsbn() {
        return this.isbn;
    }
    public Integer getRating() {
        return this.rating;
    }
    public String getReviewer() {
        return this.reviewer;
    }
    public String getReview() {
        return this.review;
    }
    public String getDate() {
        Format formatter = new SimpleDateFormat("MM/dd/yyyy");
        String string = formatter.format(this.date);
        return string;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setRating(Integer rating) {
        this.rating = rating;
    }
    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }
    public void setReview(String review) {
        this.review = review;
    }
    public void setDate(Date date) {
        this.date = date;
    }
}
