package com.smartspend;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ViewExpenseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        double budget = Double.parseDouble(req.getParameter("budget"));
        double total = 0;

        StringBuilder report = new StringBuilder("<h2>Your Expenses:</h2>");
        try (Connection conn = DBUtil.getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM expenses");
            while (rs.next()) {
                String title = rs.getString("title");
                double amount = rs.getDouble("amount");
                String date = rs.getString("date");
                total += amount;
                report.append("<p>").append(title).append(" - ₹").append(amount).append(" - ").append(date).append("</p>");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        report.append("<h3>Total Spent: ₹").append(total).append("</h3>");
        if (total > budget) {
            report.append("<p style='color:red;'>⚠ Budget Exceeded! Consider reducing expenses.</p>");
        } else {
            report.append("<p style='color:green;'>✅ Within Budget.</p>");
        }

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        out.println(report.toString());
    }
}