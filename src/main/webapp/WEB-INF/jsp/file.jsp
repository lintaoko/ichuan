<%--
  Created by IntelliJ IDEA.
  User: 12442
  Date: 2019/3/17
  Time: 23:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 th:inlines="text">文件上传</h1>
<form action="/file/upload" method="post" enctype="multipart/form-data" >
    <p>选择文件1: <input type="file" name="file"/></p>
    <p>选择文件2: <input type="file" name="file"/></p>
    <p>选择文件3: <input type="file" name="file"/></p>
    <p><input type="submit" value="提交"/></p>
</form>
</body>
</html>
