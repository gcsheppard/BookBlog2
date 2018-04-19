package edu.acc.jweb.bookblog2;

import java.sql.Connection;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.servlet.ServletContext;
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
        try {
            Connection connection = dataSource.getConnection();
            sce.getServletContext().setAttribute("bookManager", new BookManager(connection));
                
            UserManager userManager = new UserManager();
            userManager.addUser("anna", "pigeon");
            sce.getServletContext().setAttribute("userManager", userManager);
        } catch (SQLException sqle) {
            throw new RuntimeException(sqle);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
