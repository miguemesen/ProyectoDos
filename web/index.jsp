<%--
  Created by IntelliJ IDEA.
  User: luisA
  Date: 6/20/2020
  Time: 11:54 AM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>Insert title here</title>
</head>
<body>
<center>
  <h1>Upload File Form</h1>
  <form action="FileUploadHandler" enctype="multipart/form-data" method="post">
    Enter File Name <input type="text" name="file_name"><br>
    Select<input type="file" name="file2" /><br>
    <input type="submit" value="upload" />
  </form>
  <%
    String file_name=(String)request.getParameter("filename");
    if(file_name!=null){
      out.println(file_name+" File uploaded successfuly");
    }
  %>
</center>
</body>
</html>
