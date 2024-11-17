<%@ page import="com.example.final_project.models.UsersDTO" %><%--
  Created by IntelliJ IDEA.
  User: Weiwen Chen
  Date: 11/17/24
  Time: 11:58 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Product</title>
    <link rel="stylesheet" href="asset/css/style.css">
    <link rel="stylesheet" href="asset/css/unify.css">
</head>
<body>

<header>
    <nav class="navbar">
        <div class="logo">SQL Injection prevention</div>
        <ul class="nav-links">
            <%
                UsersDTO user = (UsersDTO) session.getAttribute("user");
                if(user != null){
            %>
            <li class="dropdown">
                <a href="#">Hi: <span id="login-name">
                    <%=user.getUser_name()%></span>
                    <%--                    ▼--%>
                </a>
            </li>
            <li><a href="logout" style="color: #e7cd9e">Logout</a></li>
            <%
                }
            %>
        </ul>
        <div class="burger">
            <div class="line1"></div>
            <div class="line2"></div>
            <div class="line3"></div>
        </div>
    </nav>
</header>

<main>
    <div class="form-container">
        <form action="add_product" method="post">
            <div class="form-group">
                <label for="product_name">Product Name:</label>
                <input type="text" id="product_name" name="product_name" class="form-control" required>
            </div>
            <div class="form-group">
                <label for="product_price">Product Price:</label>
                <input type="number" id="product_price" name="product_price" class="form-control" required>
            </div>
            <button type="submit">Submit</button>
        </form>
    </div>
</main>

</body>
</html>
