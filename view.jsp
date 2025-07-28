<%@ page import="java.util.*, com.smartspend.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Your Expenses</title>
    <link rel="stylesheet" href="style.css">
</head>
<body>
    <h2>Your Expenses</h2>

    <form method="post" action="viewExpenses">
        <label for="budget">Daily Budget: ₹</label>
        <input type="number" id="budget" name="budget" step="0.01" required>
        <button type="submit">Check</button>
    </form>

    <hr>

    <%-- Future rendering of expenses list or result will go here --%>
    <%-- Example placeholder
    <table>
        <tr><th>Title</th><th>Amount</th><th>Date</th></tr>
        <% for (Expense exp : (List<Expense>) request.getAttribute("expenses")) { %>
            <tr>
                <td><%= exp.getTitle() %></td>
                <td>₹<%= exp.getAmount() %></td>
                <td><%= exp.getDate() %></td>
            </tr>
        <% } %>
    </table>
    --%>

</body>
</html>
