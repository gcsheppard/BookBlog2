package edu.acc.jweb.bookblog2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/addbook"})
public class AddBookServlet extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        getServletContext().getRequestDispatcher("/WEB-INF/views/addbook.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");
        String review = request.getParameter("review");
        
        Book book = new Book(title, author, isbn, review);
        BookManager bookManager = (BookManager) getServletContext().getAttribute("bookManager");
        String errors = bookManager.validBook(book);
        
        if (errors.isEmpty()) {
            bookManager.addBook(title, author, isbn, review);
            response.sendRedirect("/BookBlog/home"); 
        }
        else {
            //put attribute book in request
            request.setAttribute("book", book);
            request.setAttribute("errors", errors);
            //forward to addbook.jsp
            getServletContext().getRequestDispatcher("/WEB-INF/views/addbook.jsp").forward(request, response);
        }
    }
}