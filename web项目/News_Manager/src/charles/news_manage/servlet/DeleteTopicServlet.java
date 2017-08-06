package charles.news_manage.servlet;

import charles.news_manage.service.NewsService;
import charles.news_manage.service.NewsTopicService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.plaf.synth.SynthEditorPaneUI;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by chaersi on 2017/8/5.
 */
public class DeleteTopicServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException{
        this.doGet(req,resp);
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException{
        PrintWriter out=resp.getWriter();
        String oldName=req.getParameter("oldName");
        boolean isDel=false;
        NewsTopicService topicService=new NewsTopicService();
        NewsService newsService=new NewsService();
        int id=topicService.findByName(oldName);
        List newsList=newsService.findAllNews(id);
        if(newsList.size()>0){
            out.print("-1");
        }else{
            isDel=topicService.doDelete(oldName);
            if(isDel){
                FindAllTopicServlet findAllTopicServlet=new FindAllTopicServlet();
                findAllTopicServlet.doGet(req,resp);
                out.print("true");
            }else{
                out.print("false");
            }
        }

    }
}
