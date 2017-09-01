package charles.news_manage.Factory;

import charles.news_manage.dao.INewsTopicDAO;
import charles.news_manage.dao.proxy.NewsTopicProxy;

/**
 * Created by Charles Zheng on 2017/8/2.
 */
public class NewsTopicFactory {

    public static INewsTopicDAO getNewInstance() throws Exception{
        INewsTopicDAO iNewsTopicDAO=null;
        try {
            iNewsTopicDAO=new NewsTopicProxy();
        } catch (Exception e) {
            throw e;
        }
        return iNewsTopicDAO;
    }
}
