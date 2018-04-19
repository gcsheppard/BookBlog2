package edu.acc.jweb.bookblog2;

import java.util.ArrayList;

public class UserManager {
    private final ArrayList<User> list;
    
    public UserManager () {
        this.list = new ArrayList<>();
    }
    
    public void addUser(String username, String password) {
        User user = new User(username, password);
        this.list.add(user);
    }
    
    public User validateUser(String username, String password) {
        User found = findUser(username);
        if (found != null) {
            if (found.getPassword().equals(PasswordHash.hashPassword(password))) {
                return found;
            }
            else {
                return null;
            }
        }
        else {
            return null;
        }
    }
    
    public User findUser(String username) {
        for(User user : list) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }
}