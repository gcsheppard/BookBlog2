package edu.acc.jweb.bookblog2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/show"})
public class ShowServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String show = (String) request.getParameter("show");
        HttpSession session = request.getSession();
        session.setAttribute("show", show);
        getServletContext().getRequestDispatcher("/home").forward(request, response);
    }
    
}
