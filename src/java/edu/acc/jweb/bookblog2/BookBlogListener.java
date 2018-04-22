package edu.acc.jweb.bookblog2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.sql.DataSource;

@DataSourceDefinition(
        name = "java:app/jdbc/BookBlog2",
        className = "org.apache.derby.jdbc.ClientDataSource",
        url = "jdbc:derby://localhost:1527/",
        databaseName = "BookBlog2",
        user = "app",
        password = "app")
@WebListener
public class BookBlogListener implements ServletContextListener {
    @Resource(lookup = "java:app/jdbc/BookBlog2")
    DataSource dataSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
            sce.getServletContext().setAttribute("bookManager", new BookManager(dataSource));
            
            try {
                Connection connection = dataSource.getConnection();
                PreparedStatement statement = connection.prepareStatement("DELETE FROM Users");
                statement.executeUpdate();
            } catch (SQLException sqle) {
            throw new RuntimeException(sqle);    
            }
            UserManager userManager = new UserManager(dataSource);
            userManager.addUser("anna", "pigeon", "Contributor");
            userManager.addUser("kinsey", "millhone", "Contributor");
            userManager.addUser("arthur", "clarke", "Contributor");
            sce.getServletContext().setAttribute("userManager", userManager);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
