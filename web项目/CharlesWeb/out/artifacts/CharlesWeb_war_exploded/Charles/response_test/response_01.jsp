<%--
  Created by IntelliJ IDEA.
  User: Charles Zheng
  Date: 2017/7/25
  Time: 21:38
--%>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
    <%
        Cookie c1=new Cookie("name","郑必武");
        Cookie c2=new Cookie("age","28");
        c1.setMaxAge(100);
        c2.setMaxAge(100);
        response.addCookie(c1);
        response.addCookie(c2);
    %>
</head>
<body>

</body>
</html>
