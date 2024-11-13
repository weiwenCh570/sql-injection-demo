<%@ page import="com.example.final_project.models.UsersDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.final_project.models.ProductsDTO" %><%--
  Created by IntelliJ IDEA.
  User: weiwen chen
  Date: 2024-07-21
  Time: 12:46 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Food Waste Reduction Platform</title>
    <link rel="stylesheet" href="asset/css/style.css">
    <script src="asset/js/script.js" defer></script>
</head>
<body>
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


    <table id="inventoryTable">
        <thead>
        <tr>
            <th>Id</th>
            <th>product name</th>
            <th>price</th>
            <th>update time</th>
<%--            <th>Actions</th>--%>
        </tr>
        </thead>
        <tbody>
        <%
            List<ProductsDTO> products = (List<ProductsDTO>) request.getAttribute("products");
            for (ProductsDTO product : products) {
        %>
        <tr>
            <td data-label="Id"><%= product.getProduct_id() %>
            </td>
            <td data-label="Name"><%= product.getProduct_name() %>
            </td>
            <td data-label="Email"><%= product.getPrice() %>
            </td>
            <td data-label="Location"><%= product.getUpdated_at() %>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>


</main>
</body>
</body>
</html>
