package edu.acc.jweb.bookblog2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

public class UserManager {
    private final DataSource dataSource;
    
    public UserManager (DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    public void addUser(String username, String password, String userrole) {
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = dataSource.getConnection();
            statement = connection.prepareStatement("INSERT INTO Users (username, password, userrole, show) values (?,?,?,?)");
            statement.setString(1, username);
            statement.setString(2, PasswordHash.hashPassword(password));
            statement.setString(3, userrole);
            statement.setString(4, "all");
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
        
        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Users WHERE username = ?");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                User user = new User();
                user.setUsername(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                user.setUserrole(resultSet.getString("userrole")); 
                return user;
            }
            else {
                return null;
            }
        } catch(SQLException sqle) {
            throw new RuntimeException(sqle);
        }            
    }
}