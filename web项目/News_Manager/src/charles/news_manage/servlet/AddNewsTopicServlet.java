package charles.news_manage.servlet;


import charles.news_manage.service.NewsTopicService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by chaersi on 2017/8/2.
 */
public class AddNewsTopicServlet extends HttpServlet {
    private NewsTopicService topicService;
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException{
        this.topicService=new NewsTopicService();
        String name=req.getParameter("name").trim();
        if(name==null||"".equals(name)){
            req.setAttribute("addMsg","新闻主题不能为空！");
        }else{
            boolean isNew=this.topicService.isNew(name);
            if(!isNew){
                req.setAttribute("addMsg","新闻主题重复！");
            }else{
                if(name.matches("\\D+")){//限制标题不能含有数字
                    boolean add=topicService.doInsert(name);
                    if(add){
                        FindAllTopicServlet findAllTopicServlet=new FindAllTopicServlet();
                        findAllTopicServlet.doGet(req,resp);
                        req.setAttribute("addMsg","主题："+name+"，添加成功！");
                    }else {
                        req.setAttribute("addMsg","主题："+name+"，添加失败，请稍后重试！");
                    }
                }else{
                    req.setAttribute("addMsg","主题："+name+"，格式不正确！");
                }

            }
        }
        req.getRequestDispatcher("News_Manage_Page.jsp").forward(req,resp);
    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException{
        this.doGet(req,resp);
    }
}
