package edu.acc.jweb.bookblog2;

public class User {
    private final String username;
    private final String password;
    
    public User (String username, String password) {
        this.username = username;
        this.password = PasswordHash.hashPassword(password);
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
}