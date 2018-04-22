package edu.acc.jweb.bookblog2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

public class BookManager {
    private final DataSource dataSource;
    
    public BookManager (DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public void addBook(String title, String author, String genre, String isbn, Integer rating, String reviewer, String review) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("INSERT INTO Books (title, author, genre, isbn, rating, reviewer, review) values (?,?,?,?,?,?,?)");
            statement.setString(1, title);
            statement.setString(2, author);
            statement.setString(3, genre);
            statement.setString(4, isbn);
            statement.setInt(5, rating);
            statement.setString(6, reviewer);
            statement.setString(7, review);
            statement.executeUpdate();
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        } finally {
            try {
                if (statement != null) { 
                    statement.close();
                } 
                if (connection != null) { 
                    connection.close();
                } 
            } catch (SQLException sqle) {
                throw new RuntimeException(sqle);
            }
        }   

    }
    
    public ArrayList<Book> getBooks() {
        ArrayList<Book> list = new ArrayList<>();
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM books");
            ResultSet resultSet = statement.executeQuery()) {
            
            while (resultSet.next()) {
                Book book = bookFromDB(resultSet);
                list.add(book);
            }
        } catch(SQLException sqle) {
            throw new RuntimeException(sqle);
        } 
        return list;
    }
    
    public String validBook(Book book) {
        String errors = "";
        
        if (book.title.isEmpty()) errors = errors + "Title not entered.<br>";
        if (book.author.isEmpty()) errors = errors + "Author not entered.<br>";
        if (book.isbn.isEmpty()) errors = errors + "ISBN not entered.<br>";
        if (book.review.isEmpty()) errors = errors + "Review not entered.<br>";
        if (!errors.isEmpty()) errors = "Error(s):<br>" + errors;
        
        return errors;
    }
    
    public Book findBookById(Integer id) {
        Book book = null;
        String sql = "select * from Books where id = " + id;
        try (Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                book = bookFromDB(resultSet);
            }
        } catch(SQLException sqle) {
            throw new RuntimeException(sqle);
        }
        return book;
    }
    
    private Book bookFromDB(ResultSet resultSet) {
        Book book = new Book();
        try {
            book.setId(resultSet.getInt("id"));
            book.setTitle(resultSet.getString("title"));
            book.setAuthor(resultSet.getString("author"));
            book.setGenre(resultSet.getString("genre"));
            book.setIsbn(resultSet.getString("isbn"));
            book.setReviewer(resultSet.getString("reviewer"));
            book.setRating(resultSet.getInt("rating"));
            book.setReview(resultSet.getString("review"));
            book.setDate(resultSet.getDate("date"));
            return book;
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }
}
