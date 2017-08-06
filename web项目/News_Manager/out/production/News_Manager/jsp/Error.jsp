<%--
  Created by IntelliJ IDEA.
  User: Charles Zheng
  Date: 2017/8/2
  Time: 17:12
--%>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title>登录失败页面</title>
</head>
<body>
<%

    response.setHeader("reflesh","2;URL=../html/login.html");
%>
<h1>
    用户名或密码错误，将跳转回登录页面，如未成功跳转，请点击<a href="../html/login.html">这里</a>!
</h1>
<form action=""></form>>
</body>
</html>
