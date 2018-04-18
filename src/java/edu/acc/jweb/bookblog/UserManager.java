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
    
    public User validateUser(User user) {
        User found = findUser(user.username);
        if (found==null) {
            return null;
        }
        if (found.password.equals(user.password)) {
            return found;
        }
        else {
            return null;
        }
    }
    
    public User findUser(String username) {
        for (int i=0; i<list.size(); i++) {
            if (list.get(i).username.equals(username)) {
                return list.get(i);
            }
        }
        return null;
    }
}
