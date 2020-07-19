<%--
  Created by IntelliJ IDEA.
  User: luisA
  Date: 6/26/2020
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="Pages/LoginPage/LoginCss.css">
</head>
<body>
<h1 id="heading"> Login</h1>
<form action="/logs" method="post">
    <p id="logPane">
        UserName: <input id="UserName" type="text" name="UserName" size="40" required>
        <br>
        Password <input id="PassInput" type="password" name="Password" size="40" required>
    </p>
    <input id="Submit" type="submit" name="send">
</form>
<br>
<br>
<a href="Pages/LoginPage/SignIn.jsp" target="_self">
  Don't have an account, register now
</a>

</body>
</html>
