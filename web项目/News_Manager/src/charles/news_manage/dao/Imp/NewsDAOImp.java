package charles.news_manage.dao.Imp;

import charles.news_manage.dao.INewsDAO;
import charles.news_manage.entity.News;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaersi on 2017/8/5.
 */
public class NewsDAOImp implements INewsDAO {
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    public NewsDAOImp(Connection conn){
        this.conn=conn;
    }
    @Override
    public List<News> findAllNews(String keyword) throws Exception{
        List<News> newsLists=new ArrayList<>();
        String sql="select id,top_id,title,content,time from news where title like ? or content like ?";
        try {
            pst=this.conn.prepareStatement(sql);
            pst.setString(1,"%"+keyword+"%");
            pst.setString(2,"%"+keyword+"%");
            rs=pst.executeQuery();
            while(rs.next()){
                News news=new News();
                news.setId(rs.getInt(1));
                news.setTopic_id(rs.getInt(2));
                news.setTitle(rs.getString(3));
                news.setContent(rs.getString(4));
                news.setTime(rs.getDate(5));
                newsLists.add(news);
            }
        } catch (Exception e) {
            throw e;
        }finally {
            rs.close();
            pst.close();
        }
        return newsLists;
    }

    @Override
    public List<News> findAllNews(int topic_id) throws Exception{
        List<News> newsList=new ArrayList<>();
        String sql="select id,topic_id,title,content,time from news where topic_id= ?";
        try {
            pst=this.conn.prepareStatement(sql);
            pst.setInt(1,topic_id);
            rs=pst.executeQuery();
            while(rs.next()){
                News news=new News();
                news.setId(rs.getInt(1));
                news.setTopic_id(rs.getInt(2));
                news.setTitle(rs.getString(3));
                news.setContent(rs.getString(4));
                news.setTime(rs.getDate(5));
                newsList.add(news);
            }
        } catch (Exception e) {
            throw e;
        }finally {
            if(rs!=null){
                rs.close();
            }
           if(pst!=null){
               pst.close();
           }
        }
        return newsList;
    }
}
