<%--
  Created by IntelliJ IDEA.
  User: Charles Zheng
  Date: 2017/7/26
  Time: 21:01
--%>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <%
        request.setCharacterEncoding("utf-8");
    %>
    <jsp:useBean id="reg" scope="request" class="com.charles.demo.Register"/>
    <title></title>
</head>
<body>
    姓名：<jsp:getProperty name="reg" property="name"/><br>
    年龄：<jsp:getProperty name="reg" property="age"/><br>
    email：<jsp:getProperty name="reg" property="email"/><br>
</body>
</html>
