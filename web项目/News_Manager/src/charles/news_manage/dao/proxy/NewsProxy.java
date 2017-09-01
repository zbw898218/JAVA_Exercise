package charles.news_manage.dao.proxy;

import charles.news_manage.dao.INewsDAO;
import charles.news_manage.dao.Imp.NewsDAOImp;
import charles.news_manage.entity.News;
import charles.news_manage.util.DatabaseConnection;

import java.sql.Connection;
import java.util.List;

/**
 * Created by chaersi on 2017/8/5.
 */
public class NewsProxy implements INewsDAO {
    private INewsDAO newsDAO;
    private Connection conn;
    public NewsProxy() throws Exception{

    }
    @Override
    public List<News> findAllNews(String keyword) throws Exception {
        this.conn=new DatabaseConnection().getConnection();
        this.newsDAO=new NewsDAOImp(this.conn);
        List<News> newsList=null;
        try{
            newsList=this.newsDAO.findAllNews(keyword);
        }catch (Exception e){
            throw e;
        }finally {
            if(this.conn!=null){
                this.conn.close();
            }
        }
        return newsList;
    }

    @Override
    public List<News> findAllNews(int topic_id) throws Exception {
        try {
            this.conn=new DatabaseConnection().getConnection();
        } catch (Exception e) {
            throw e;
        }
        this.newsDAO=new NewsDAOImp(this.conn);
        List<News> newsList=null;
        try{
            newsList=this.newsDAO.findAllNews(topic_id);
        }catch (Exception e){
            throw e;
        }finally {
            if(this.conn!=null){
                this.conn.close();
            }
        }
        return newsList;
    }
}
