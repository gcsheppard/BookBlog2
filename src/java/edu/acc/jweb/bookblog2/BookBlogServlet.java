package edu.acc.jweb.bookblog2;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"", "/home"})
public class BookBlogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        BookManager bookManager = (BookManager) getServletContext().getAttribute("bookManager");
        ArrayList<Book> books = bookManager.getBooks();
        request.setAttribute("books", books);
        getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }
}