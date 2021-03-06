package edu.acc.jweb.bookblog2;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"", "/home"})
public class BookBlogServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<Book> books = null;
        BookManager bookManager = (BookManager) getServletContext().getAttribute("bookManager");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            String show = (String) user.getShow();
            if (show.equalsIgnoreCase("mine")) {
                books = bookManager.getBooksByReviewer(user);
            } else {
                books = bookManager.getBooks();
            }
        } else {
            books = bookManager.getBooks();
        }
        request.setAttribute("books", books);
        getServletContext().getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
    }
}