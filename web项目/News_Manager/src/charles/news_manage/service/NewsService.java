package charles.news_manage.service;

import charles.news_manage.Factory.NewsFactory;
import charles.news_manage.dao.INewsDAO;
import charles.news_manage.entity.News;

import java.util.List;

/**
 * Created by chaersi on 2017/8/5.
 */
public class NewsService {
    private INewsDAO newsDAO=null;
    public NewsService(){
        try {
            this.newsDAO= NewsFactory.getNewInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public List<News> findAllNews(int topic_id){
        List<News> newsList=null;
        try {
            newsList=this.newsDAO.findAllNews(topic_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsList;
    }
}
