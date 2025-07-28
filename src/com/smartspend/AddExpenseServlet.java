package com.smartspend;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AddExpenseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");

        String title = req.getParameter("title");
        double amount = Double.parseDouble(req.getParameter("amount"));
        String date = req.getParameter("date");

        try {
            Connection conn = DBUtil.getConnection();
            String sql = "INSERT INTO expenses (title, amount, date) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setDouble(2, amount);
            ps.setString(3, date);
            ps.executeUpdate();
            conn.close();
            // ✅ Safe redirect AFTER success
            res.sendRedirect("index.jsp");
        } catch (Exception e) {
            // ✅ Show error on the page if DB fails
            PrintWriter out = res.getWriter();
            out.println("<h3>Database Error:</h3>");
            out.println("<pre>" + e.getMessage() + "</pre>");
        }
    }
}

