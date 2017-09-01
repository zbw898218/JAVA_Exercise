<%--
  Created by IntelliJ IDEA.
  User: Charles Zheng
  Date: 2017/7/26
  Time: 20:55
--%>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<html>
<head>
<jsp:useBean id="reg" scope="request" class="com.charles.demo.Register"/>
    <%
        request.setCharacterEncoding("utf-8");
    %>
    <title></title>
</head>
<body>
<form action="check.jsp" method="post">
    姓名：<input type="text" name="name" value="<jsp:getProperty name="reg" property="name"/>"><%=reg.getErrorMsg("errname")%><br>
    年龄：<input type="text" name="age" value="<jsp:getProperty name="reg" property="age"/>"><%=reg.getErrorMsg("errage")%><br>
    email：<input type="text" name="email" value="<jsp:getProperty name="reg" property="email"/>"><%=reg.getErrorMsg("erremail")%><br>
    <input type="submit" name="submit" value="提交"><input type="reset" name="reset" value="重置">
</form>
</body>
</html>
