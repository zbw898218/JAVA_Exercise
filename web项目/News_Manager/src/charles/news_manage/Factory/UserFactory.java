package charles.news_manage.Factory;

import charles.news_manage.dao.IUserDAO;
import charles.news_manage.dao.proxy.UserProxy;

/**
 * Created by Charles Zheng on 2017/8/2.
 */
public class UserFactory {
    public static IUserDAO getNewInstance() throws Exception{
        IUserDAO userDAO=null;
        try{
            userDAO=new UserProxy();
        }catch (Exception e) {
            throw e;
        }
       return userDAO;
    }
}
