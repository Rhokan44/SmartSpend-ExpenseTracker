package com.smartspend;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class AddExpenseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String title = req.getParameter("title");
        double amount = Double.parseDouble(req.getParameter("amount"));
        String date = req.getParameter("date");

        try (Connection conn = DBUtil.getConnection()) {
            String sql = "INSERT INTO expenses (title, amount, date) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, title);
            ps.setDouble(2, amount);
            ps.setString(3, date);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        res.sendRedirect("index.jsp");
    }
}