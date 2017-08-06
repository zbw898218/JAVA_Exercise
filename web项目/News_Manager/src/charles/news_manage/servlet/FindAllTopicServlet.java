package charles.news_manage.servlet;

import charles.news_manage.entity.NewsTopic;
import charles.news_manage.service.NewsTopicService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by chaersi on 2017/8/5.
 */
public class FindAllTopicServlet extends HttpServlet {
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException{
        this.doGet(req,resp);
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException{
        NewsTopicService topicService=new NewsTopicService();
        List<NewsTopic> topicList=topicService.findAll("");
        if(topicList.size()!=0) {
            String[] topicName=new String[topicList.size()];
            for(int i=0;i<topicList.size();i++){
                topicName[i]=topicList.get(i).getName();
            }
            req.getSession().setAttribute("topicName",topicName);
        }else{
            req.getSession().setAttribute("topicName",null);
        }
    }
}
