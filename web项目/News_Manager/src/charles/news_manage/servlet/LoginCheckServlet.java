package charles.news_manage.servlet;


import charles.news_manage.Factory.UserFactory;
import charles.news_manage.dao.IUserDAO;
import charles.news_manage.entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Charles Zheng on 2017/8/2.
 */
public class LoginCheckServlet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException{
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        boolean login=false;
        try {
            IUserDAO userDAO=UserFactory.getNewInstance();
            login=userDAO.findByUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
       if(login ){
           req.getSession().setAttribute("userInfo",user);
            if(user.getLevel()==1){
                FindAllTopicServlet findAllTopicServlet=new FindAllTopicServlet();
                findAllTopicServlet.doGet(req,resp);
                resp.sendRedirect("../jsp/News_Manage_Page.jsp");
            }else {
                req.getRequestDispatcher("../jsp/Customer_index_Page.jsp").forward(req,resp);
            }
       }else{
            resp.sendRedirect("../jsp/Error.jsp");
       }

    }
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, java.io.IOException{
        this.doGet(req,resp);
    }
}
