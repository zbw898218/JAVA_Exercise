<%--
  Created by IntelliJ IDEA.
  User: Charles Zheng
  Date: 2017/8/2
  Time: 15:19
--%>
<%@ page contentType="text/html" language="java" pageEncoding="UTF-8" %>
<%@ page import="java.util.*" %>
<%@ page import="charles.news_manage.service.NewsService" %>
<%@ page import="charles.news_manage.service.NewsTopicService" %>
<%@ page import="charles.news_manage.entity.News" %>
<%@ page import="charles.news_manage.entity.NewsTopic" %>
<html>
  <head>
    <title></title>
    <link rel="stylesheet" type="text/css" href="../css/index_page.css"/>
    <%
      NewsService newsService=new NewsService();
      NewsTopicService newsTopicService=new NewsTopicService();
      List<NewsTopic> allTopic=newsTopicService.findAll("");
      List<News> newsList1=newsService.findAllNews(newsTopicService.findByName("国内"));
      List<News> newsList2=newsService.findAllNews(newsTopicService.findByName("国际"));
      List<News> conList1=newsService.findAllNews(newsTopicService.findByName("国内"));
      List<News> conList2=newsService.findAllNews(newsTopicService.findByName("国际"));
    %>
  </head>
  <body>
  <div class="body">
    <div class="top_body">
      <div>
        <p>
        <form action="/html/LoginServlet" method="post">
          <span>登录名：</span><input type="text" name="username">&nbsp;&nbsp;
          <span>密&nbsp;码：</span><input type="password" name="password">&nbsp;&nbsp;
          <input type="submit" name="sub" value="登录">
        </form>
        </p>
      </div>
      <div >
        <iframe src="html/header.html" height="80px" width="1050px" frameborder="0"></iframe>
        <hr />
      </div>

    </div>
    <div class="left_body">
      <div class="news_list" id="news_list_1">
        <p id="title_1"><img src="../images/title_1.gif" width="200px"/></p>
        <ul id="list_1" class="left_body_list" onload="showMsg1()">
          <%
            try {
                Iterator<News> iter1=newsList1.iterator();
                while (iter1.hasNext()){
                    News news=iter1.next();
                    pageContext.setAttribute("title1",news.getTitle());
          %>
          <li><a href="#">${pageScope.title1}</a></li>
          <%
                }
            }catch (Exception e){
                e.printStackTrace();
            }
          %>
        </ul>
      </div>
      <div class="news_list" id="news_list_2">
        <p id="title_2"><img src="../images/title_2.gif" width="200px"/></p>
        <ul id="list_2" class="left_body_list" onload="showMsg1()">
          <%
            try {
              Iterator<News> iter2=newsList2.iterator();
              while (iter2.hasNext()){
                pageContext.setAttribute("title2",iter2.next().getTitle());
          %>
          <li><a href="#">${pageScope.title2}</a></li>
          <%
              }
            }catch (Exception e){
              e.printStackTrace();
            }
          %>
        </ul>
      </div>
    </div>
    <div class="mid_body">
      <div class="mid_body_top">
        <img src="../images/class_type.gif" width="150px" height="30px" id="mid_body_img1"/>
        <img src="../images/blue_bar.png" height="30px" id="mid_body_img2"/>
      </div>
      <div class="mid_body_mid_top">
        <div class="news_topic_list">
          <ul id="">
            <%
              try {
                Iterator<NewsTopic> iter3=allTopic.iterator();
                while (iter3.hasNext()){
                  pageContext.setAttribute("title3",iter3.next().getName());
            %>
            <li><a href="#">${pageScope.title3}</a></li>
            <%
                }
              }catch (Exception e){
                e.printStackTrace();
              }
            %>
          </ul>
        </div>
      </div>
      <div class="mid_body_mid_mid">
        <div class="mid_body_mid_mid_1">
          <ul>
            <%
              try {
                Iterator<News> iter4=conList1.iterator();
                while (iter4.hasNext()){
                    News news=iter4.next();
                  pageContext.setAttribute("times1",news.getTime());
                  pageContext.setAttribute("conList1",news.getContent());
            %>
            <li>
              <a href="#">${pageScope.conList1}</a>
              <p class="news_time">${pageScope.times1}</p>
            </li>
            <%
                }
              }catch (Exception e){
                e.printStackTrace();
              }
            %>
          </ul>
        </div>
        <div class="mid_body_mid_mid_2">
          <ul>
            <%
              try {
                Iterator<News> iter5=conList2.iterator();
                while (iter5.hasNext()){
                  News news=iter5.next();
                  pageContext.setAttribute("times2",news.getTime());
                  pageContext.setAttribute("conList2",news.getContent());
            %>
            <li>
              <a href="#">${pageScope.conList2}</a>
              <p class="news_time">${pageScope.times2}</p>
            </li>
            <%
                }
              }catch (Exception e){
                e.printStackTrace();
              }
            %>
          </ul>
        </div>
      </div>

    </div>
    <div class="bottom_top">
    </div>
  </div>
  </body>
</html>
