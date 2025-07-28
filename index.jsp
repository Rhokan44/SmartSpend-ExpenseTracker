<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>SmartSpend – Personal Expense Tracker</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
  <style>
    body {
      background-color: #f8f9fa;
    }
    .hero {
      padding: 80px 20px;
      background: linear-gradient(135deg, #0d6efd, #0a58ca);
      color: white;
      text-align: center;
    }
    .hero h1 {
      font-size: 3rem;
    }
    .btn-custom {
      background-color: white;
      color: #0d6efd;
      font-weight: bold;
    }
  </style>
</head>
<body>

<!-- Navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light"> <!-- 1 -->
  <div class="container-fluid">                              <!-- 2 -->
    <a class="navbar-brand fw-bold text-primary" href="#">SmartSpend</a>
    <div class="d-flex">                                     <!-- 3 -->
      <a class="btn btn-outline-secondary me-2" href="login.jsp">Login</a>
      <a class="btn btn-outline-primary me-2" href="add.jsp">Add Expense</a>
      <a class="btn btn-outline-success" href="view.jsp">View Dashboard</a>
    </div> 
  </div>   
</nav>     

<!-- Hero Section -->
<section class="hero">
  <h1>Track Your Expenses Smartly</h1>
  <p class="lead mt-3">SmartSpend helps you manage your money with ease.</p>
  <a href="add.html" class="btn btn-custom mt-4 px-4 py-2">Get Started</a>
</section>

<!-- Footer -->
<footer class="text-center mt-5 mb-3 text-muted">
  &copy; 2025 SmartSpend. All rights reserved.
</footer>

</body>
</html>
