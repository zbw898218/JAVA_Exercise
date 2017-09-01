package charles.news_manage.servlet;

import charles.news_manage.entity.News;
import charles.news_manage.service.NewsService;
import charles.news_manage.service.NewsTopicService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.JspWriter;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

/**
 * Created by chaersi on 2017/8/6.
 */
public class NewsTitleServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException{
        this.doGet(req,resp);
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException{
        NewsService newsService=new NewsService();
        NewsTopicService newsTopicService=new NewsTopicService();
        PrintWriter out=resp.getWriter();
        String topic=req.getParameter("topic");
        int id=newsTopicService.findByName(topic);
        List<News> newsList=newsService.findAllNews(id);
        if(newsList.size()>0){
            String[] titleNames=new String[newsList.size()];
            for(int i=0;i<newsList.size();i++){
                String title=newsList.get(i).getTitle();
                if(title.length()>10){
                    title=title.substring(0,10)+"...";
                }
                titleNames[i]=title;
            }
            req.getSession().setAttribute("titleNames",titleNames);
            out.print("true");
        }else{
            out.print("false");
            req.getSession().setAttribute("titleNames",0);
        }
    }
}
