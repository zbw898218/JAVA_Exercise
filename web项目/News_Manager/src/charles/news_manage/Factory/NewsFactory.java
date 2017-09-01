package charles.news_manage.Factory;

import charles.news_manage.dao.INewsDAO;
import charles.news_manage.dao.proxy.NewsProxy;

/**
 * Created by chaersi on 2017/8/5.
 */
public class NewsFactory {
    public static INewsDAO getNewInstance() throws Exception{
        INewsDAO newsDAO= null;
        try {
            newsDAO = new NewsProxy();
        } catch (Exception e) {
            throw e;
        }
        return newsDAO;
    }
}
