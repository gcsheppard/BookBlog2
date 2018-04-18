package edu.acc.jweb.bookblog2;

import java.util.ArrayList;

public class BookManager {
    private final ArrayList<Book> list;
    
    public BookManager () {
        this.list = new ArrayList<>();
    }
    
    public void addBook(String title, String author, String isbn, String review) {
        Book book = new Book(title, author, isbn, review);
        list.add(book);
        while (list.size() > 10) {
            list.remove(0);
        }
    }
    
    public ArrayList<Book> getBooks() {
        return list;
    }
    
}

