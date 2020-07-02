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
    <style>
        body{
            background-color: yellow;
        }

        #heading{
            color: black;
            text-align: center;
            font-size:40px;
        }
        #logPane{
            align-content: center;

        }
        h1{
            background-color: blue;
        }

    </style>
</head>
<body>
<h1 id="heading"> Login</h1>
<form action="/Init/logs" method="post">
    <p id="logPane">
        User: <input id="UserName" type="text" name="UserName" size="40">
        <br>
        Password <input id="PassInput" type="password" name="Password" size="40">
    </p>
    <input id="Submit" type="submit" name="send">
</form>
<br>
<br>
<a href="Pages/LoginPage/SingIn.jsp" target="_self">
  Don't have an account, register now
</a>
</body>
</html>
