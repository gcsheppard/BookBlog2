package edu.acc.jweb.bookblog2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/details"})
public class DetailsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        Integer id = integerFromParameter(request);
        if (id == null) {
            response.sendError(404, "Not Found");
        } else {
            BookManager bookManager = (BookManager) getServletContext().getAttribute("bookManager");
            Book book = bookManager.findBookById(id);
            if (book == null) {
                response.sendError(404, "Not Found");
            }
            else {
                request.setAttribute("book", book);
                getServletContext().getRequestDispatcher("/WEB-INF/views/details.jsp").forward(request, response);
            }
        }
    }
    
    private Integer integerFromParameter(HttpServletRequest request) {
        String str = request.getParameter("id");
        if (str == null) {
            return null;
        } else if (str.isEmpty()) {
            return null;
        } else try {
            return Integer.parseInt(request.getParameter("id"));
        } catch (Exception e) {
            return null;
        }
    }
}
