<%@ page import="java.util.*, com.smartspend.*" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head><title>Expenses</title></head>
<body>
    <h2>Your Expenses</h2>
    <form method="post" action="viewExpenses">
        Daily Budget: ₹<input type="number" name="budget">
        <button type="submit">Check</button>
    </form>
</body>
</html>