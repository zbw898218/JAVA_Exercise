package charles.news_manage.servlet;

import charles.news_manage.entity.NewsTopic;
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
 * Created by chaersi on 2017/8/3.
 */
public class AlterTopicServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException{
        this.doGet(req,resp);
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException{
        PrintWriter out=resp.getWriter();
        String oldName=req.getParameter("oldName");
        String newName=req.getParameter("newName");
        if(newName==null||"".equals(newName)){
            out.print("-1");
        }else if(!newName.matches("\\D+")){
            out.print("-2");
        }else{
            NewsTopicService topicService=new NewsTopicService();
            boolean update=topicService.doUpdate(oldName,newName);
            resp.setContentType("text/html");
            if(update){
                FindAllTopicServlet findAllTopicServlet=new FindAllTopicServlet();
                findAllTopicServlet.doGet(req,resp);
                out.print("true");
            }else{
                out.print("false");
            }
        }
    }
}
