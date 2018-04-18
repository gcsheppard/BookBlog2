package edu.acc.jweb.bookblog2;

import javax.annotation.sql.DataSourceDefinition;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@DataSourceDefinition(
        name = "java:app/jdbc/BookBlog2",
        className = "org.apache.derby.jdbc.ClientDataSource",
        url = "jdbc:derby://localhost:1527/",
        databaseName = "BookBlog2",
        user = "app",
        password = "app")
@WebListener
public class BookBlogListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        BookManager bookManager = new BookManager();
        bookManager.addBook("The Hobbit", "J.R.R. Tolkien", "978-0618968633", "What can you say about a classic? Great book. Everyone should read it.");
        ServletContext sc = sce.getServletContext();
        sc.setAttribute("bookManager", bookManager);
        
        UserManager userManager = new UserManager();
        userManager.addUser("admin", "password");
        sc.setAttribute("userManager", userManager);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
