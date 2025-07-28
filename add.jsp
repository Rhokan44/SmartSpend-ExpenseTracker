<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Add Expense - SmartSpend</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body style="background-color:#f8f9fa;">

  <div class="container mt-5">
    <h2 class="text-primary mb-4">Add New Expense</h2>
    
    <form action="AddExpenseServlet" method="post">
      <div class="mb-3">
        <label for="title" class="form-label">Expense Name</label>
        <input type="text" class="form-control" id="title" name="title" required>
      </div>
      <div class="mb-3">
        <label for="amount" class="form-label">Amount (₹)</label>
        <input type="number" class="form-control" id="amount" name="amount" required>
      </div>
      <div class="mb-3">
        <label for="date" class="form-label">Date</label>
        <input type="date" class="form-control" id="date" name="date" required>
      </div>
      <button type="submit" class="btn btn-success">Add Expense</button>
    </form>

  </div>

</body>
</html>
