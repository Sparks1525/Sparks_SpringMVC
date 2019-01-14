<%--
  Created by IntelliJ IDEA.
  User: kerwin
  Date: 2017/9/12
  Time: 上午11:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>file</title>
</head>
<body>
<form action="/springMVCDemo3/upload" method="post" enctype="multipart/form-data">
    文件:<input type="file" name="file"><br>
    <input type="submit" value="提交">
</form>
</body>
</html>
