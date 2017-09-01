<%--
  Created by IntelliJ IDEA.
  User: Charles Zheng
  Date: 2017/8/2
  Time: 17:48
--%>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<%@page import="java.util.*" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>新闻管理页面</title>
    <link rel="stylesheet" type="text/css" href="../css/manage_page.css"/>
    <script src="jquery-1.8.3.js"></script>
    <script src="../js/alterTopicName.js"></script>
    <%
        if(session.getAttribute("userInfo")==null){
            response.sendRedirect("../html/login.html");
        }
    %>
</head>
<body >
<div class="body">
    <div class="head">
        <div class="head_top">
            欢迎使用新闻管理系统！
        </div>
        <div>
            <iframe src="../html/header.html" height="80px" width="1050px" frameborder="0"></iframe>
            <hr />
        </div>
        <div class="head_foot" >
            欢迎管理员：${sessionScope.userInfo.username} &nbsp;&nbsp;&nbsp;<a href="../html/login.html" >login out</a>
        </div>
    </div>
    <div class="left_body">
        <ul>
            <li><a href="#">添加新闻</a></li>
            <li><a href="#">编辑新闻</a></li>
            <li><a href="#">添加主题</a></li>
            <li><a href="#">编辑主题</a></li>
        </ul>
    </div>
    <div class="main_body" >
        <div class="main_body_tab1">
            <form action="Add_Topic_Servlet" method="post">
                <table cellpadding="50px" cellspacing="45px"  >
                    <tr >
                        <th id="add_topic" colspan="2">添加主题</th>
                    </tr>
                    <tr>
                        <td >主题名称：<input type="text" name="name"/></td>
                        <td id="msg" onchange="showMsg()">${requestScope.addMsg}</td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="提交" />&nbsp;&nbsp;&nbsp;
                            <input type="reset" value="重置" />
                        </td>
                    </tr>
                </table>
            </form>
        </div>
        <div class="main_body_tab2">
            <table cellpadding="10px" cellspacing="10px">
                <%
                    String[] topicName=(String[])session.getAttribute("topicName");
                    if(topicName!=null){
                        for(String names:topicName){
                            pageContext.setAttribute("topicName",names);
                %>
                <tr >
                    <td id=<%=names%>>${topicName}</td>
                    <td><a href="#" onclick="altetTopicName(<%=names%>)">修改</a></td>
                    <td><a href="#" onclick="deleteTopicName(<%=names%>)">删除</a></td>
                </tr>
                <%
                        }
                    }
                %>
            </table>
        </div>
        <div class="main_body_tab3">
            dv
        </div>
        <div class="main_body_tab4">
            dv
        </div>
    </div>
</div>
</body>
<script>
    function showMsg() {
        var msg=document.getElementById("msg");
        alert(msg.innerHTML);
    }
</script>
</html>
