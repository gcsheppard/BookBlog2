package edu.acc.jweb.bookblog2;

public class User {
    public String username;
    public String password;
    public String userrole;
    
    public User () {}

    public User (String username, String password, String userrole) {
        this.username = username;
        this.password = PasswordHash.hashPassword(password);
        this.userrole = userrole;
    }
    
    public String getUsername() {
        return this.username;
    }
    
    public String getPassword() {
        return this.password;
    }
    
    public String getUserrole() {
        return this.userrole;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserrole(String userrole) {
        this.userrole = userrole;
    }

}