<%--
  Created by IntelliJ IDEA.
  User: luisA
  Date: 6/26/2020
  Time: 4:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Sign in tab</title>
</head>
<body>
<form action="/Init/" method="get">
    <p id="logPane">
        User: <input id="UserName" type="text" name="UserName" size="40">
        <br>
        Password <input id="PassInput" type="password" name="Password" size="40">
    </p>
    <input id="Submit" type="submit" name="register">
</form>

</body>
</html>
