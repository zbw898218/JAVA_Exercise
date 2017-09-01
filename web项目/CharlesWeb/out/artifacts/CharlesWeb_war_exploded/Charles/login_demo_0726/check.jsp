<%--
  Created by IntelliJ IDEA.
  User: Charles Zheng
  Date: 2017/7/26
  Time: 21:00
--%>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <jsp:useBean id="reg" scope="request" class="com.charles.demo.Register"/>
    <%
        request.setCharacterEncoding("utf-8");
    %>
    <title></title>
    <jsp:setProperty name="reg" property="*"/>
    <%
        if(reg.isVilidate()){
     %>
    <jsp:forward page="success.jsp"/>
    <%
        }else{
    %>
    <jsp:forward page="index.jsp"/>
    <%
        }
    %>

</head>
<body>

</body>
</html>
