<%--
  Created by IntelliJ IDEA.
  User: Charles Zheng
  Date: 2017/7/25
  Time: 21:59
--%>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <title></title>
</head>
<body>
<%
    Cookie[] cookies=request.getCookies();
    for(int i=0;i<cookies.length;i++){
        String name=cookies[i].getName();
        String value=cookies[i].getValue();
%>
        <h2><%=name%>---><%=value%></h2>
<%
    }
%>
</body>
</html>
