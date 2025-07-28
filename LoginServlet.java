package com.smartspend;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Hardcoded credentials
    private final String USERNAME = "admin";
    private final String PASSWORD = "1234";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            // Login success - store in session
            HttpSession session = request.getSession();
            session.setAttribute("user", username);

            // Redirect to index.jsp
            response.sendRedirect("index.jsp");
        } else {
            // Login failed - show login page again
            response.sendRedirect("login.jsp?error=1");
        }
    }
}
