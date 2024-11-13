<%@ page import="java.util.Map" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: weiwen chen
  Date: 2024-07-18
  Time: 4:55 p.m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>register</title>
    <link rel="stylesheet" href="asset/css/authenticate.css">
    <%--    <script src="../asset/js/register.js" defer></script>--%>
    <%--    <script src="../asset/js/function.js" defer></script>--%>
</head>
<body>
<div class="container register_c">
    <h1>Register</h1>
    <form id="loginForm" method="post" action="register">
        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" id="name" name="name">
            <span id="name-s"></span>
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" id="email" name="email">
            <span id="email-s"></span>
        </div>
        <div class="form-group">
            <label for="phone">Phone Number:</label>
            <input type="text" id="phone" name="phone">
            <span id="phone-s"></span>
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password">
            <span id="pass-s"></span>
        </div>
        <div class="form-group">
            <label for="re-password">Re-Password:</label>
            <input type="password" id="re-password" name="re-password">
            <span id="pass2-s"></span>
        </div>
        <div class="form-group">
            <label for="type">Type:</label>
            <select id="type" name="type">
                <%
                    List<Map<Integer, String>> userTypes = (List<Map<Integer, String>>) request.getAttribute("userTypes");
                    if (userTypes != null) {
                        for (Map<Integer, String> map : userTypes) {
                            for (Map.Entry<Integer, String> entry : map.entrySet()) {
                                out.println("<option value=\"" + entry.getKey() + "\">" + entry.getValue() + "</option>");
                            }
                        }
                    }
                %>
            </select>
        </div>
        <div class="form-group">
            <label for="location">Location:</label>
            <input type="text" id="location" name="location">
            <span id="location-s"></span>
        </div>
        <div class="form-group">
            <label for="postal-code">Postal code:</label>
            <input type="text" id="postal-code" name="postal-code">
            <span id="postal-code-s"></span>
        </div>
        <button type="submit">Register</button>
        <%--        <button onclick="reset2()" type="reset">reset</button>--%>
        <p id="successText"></p>
        <p id="errorText" class="error-text">
            <%
                String errMsg = (String) request.getAttribute("error");
                if (errMsg != null) {
                    out.println(errMsg);
                }
            %>
        </p>
    </form>
</div>
</body>
</html>
