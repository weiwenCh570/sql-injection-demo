<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login2 without validation</title>
    <link rel="stylesheet" href="asset/css/authenticate.css">
</head>
<body>
<div class="container">
    <h1>Login(allow sql injection)</h1>
    <form id="loginForm" method="post" action="login2">
        <div class="form-group">
            <label for="email">Username:</label>
            <input type="text" id="email" name="email">
        </div>
        <div class="form-group">
            <label for="password">Password:</label>
            <input type="password" id="password" name="password">
        </div>
        <button type="submit">Login</button>
        <p id="errorText" class="error-text">
            <%
                String errMsg = (String) request.getAttribute("error");
                if (errMsg != null) {
                    out.println(errMsg);
                }
            %>
        </p>
    </form>
    <%--    <p id="register-hint">No account yet? <a href="register">Register</a></p>--%>
</div>
</body>
</html>
