package com.smartspend;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;

public class ViewExpenseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        req.setCharacterEncoding("UTF-8");
        res.setContentType("text/html; charset=UTF-8");

        PrintWriter out = res.getWriter();
        double total = 0;
        double budget = 0;

        try {
            String budgetStr = req.getParameter("budget");
            if (budgetStr != null && !budgetStr.isEmpty()) {
                budget = Double.parseDouble(budgetStr);
            }

            out.println("<html><head><title>Your Expenses</title></head><body>");
            out.println("<h2>Your Expenses:</h2>");
            out.println("<table border='1'><tr><th>Title</th><th>Amount (₹)</th><th>Date</th></tr>");

            try (Connection conn = DBUtil.getConnection()) {
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT title, amount, date FROM expenses");

                while (rs.next()) {
                    String title = rs.getString("title");
                    double amount = rs.getDouble("amount");
                    String date = rs.getString("date");

                    out.println("<tr><td>" + title + "</td><td>₹" + amount + "</td><td>" + date + "</td></tr>");
                    total += amount;
                }

                out.println("</table>");
                out.printf("<h3>Total Spent: ₹%.2f</h3>", total);

                if (budget > 0) {
                    if (total > budget) {
                        out.println("<p style='color:red;'>❌ Over Budget!</p>");
                    } else {
                        out.println("<p style='color:green;'>✅ Within Budget.</p>");
                    }
                }

            } catch (Exception e) {
                out.println("<h3>Database Error:</h3>");
                out.println("<pre>" + e.getMessage() + "</pre>");
            }

            out.println("</body></html>");
        } catch (NumberFormatException e) {
            out.println("<h3>Invalid budget input.</h3>");
        }
    }
}
