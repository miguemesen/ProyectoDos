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
<form action="/register" method="post">
    <p id="logPane">
        First Name<input id="Name" type="text" name="FirstName" size="40" required>
        <br>
        First Name<input id="LastName" type="text" name="LastName" size="40" required>
        <br>
        User: <input id="UserName" type="text" name="UserName" size="40" required>
        <br>
        Password <input id="PassInput" type="password" name="Password" size="40" required>
        <br>
        Age <input id="Age" type="number" name="Age" size="40" required>
        <br>


    </p>
    <input id="Submit" type="submit" name="register">
</form>

</body>
</html>
