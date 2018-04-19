package edu.acc.jweb.bookblog2;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Book {
    public int id;
    public String title;
    public String author;
    public String isbn;
    public String review;
    public Date date;
    
    public Book (String title, String author, String isbn, String review) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.review = review;
        this.date = new Date();
    }
    
    public String getTitle() {
        return this.title;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public String getISBN() {
        return this.isbn;
    }
    
    public String getReview() {
        return this.review;
    }
    
    public String getDate() {
        Format formatter = new SimpleDateFormat("MM/dd/yyyy");
        String string = formatter.format(this.date);
        return string;
    }
}
