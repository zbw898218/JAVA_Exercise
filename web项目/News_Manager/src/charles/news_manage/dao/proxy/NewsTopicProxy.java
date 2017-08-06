package charles.news_manage.dao.proxy;

import charles.news_manage.dao.INewsTopicDAO;
import charles.news_manage.dao.Imp.NewsTopicDAOImp;
import charles.news_manage.entity.NewsTopic;
import charles.news_manage.util.DatabaseConnection;

import java.sql.Connection;
import java.util.List;

/**
 * Created by Charles Zheng on 2017/8/2.
 */
public class NewsTopicProxy implements INewsTopicDAO {
    private NewsTopicDAOImp newsTopicDAOImp=null;
    private Connection conn=null;
    public NewsTopicProxy() throws Exception{

    }
    @Override
    public List<NewsTopic> findAll(String keywords) throws Exception {
        try {
            conn=new DatabaseConnection().getConnection();
        } catch (Exception e) {
            throw e;
        }
        this.newsTopicDAOImp=new NewsTopicDAOImp(conn);
        List<NewsTopic> newsTopicList=null;
        try {
            newsTopicList =this.newsTopicDAOImp.findAll(keywords);
        }catch(Exception e){
            throw e;
        }finally {
            if(this.conn!=null){
                this.conn.close();
            }
        }
        return newsTopicList;
    }
    @Override
    public int findByName(String name) throws Exception {
        int id=0;
        try {
            conn=new DatabaseConnection().getConnection();
        } catch (Exception e) {
            throw e;
        }
        this.newsTopicDAOImp=new NewsTopicDAOImp(conn);
        try{
            id=this.newsTopicDAOImp.findByName(name);
        } catch(Exception e){
            throw e;
        }finally {
            if(this.conn!=null){
                this.conn.close();
            }
        }
        return id;
    }

    @Override
    public boolean deleteById(int id) throws Exception {
        boolean isDel=false;
        try {
            conn=new DatabaseConnection().getConnection();
        } catch (Exception e) {
            throw e;
        }
        this.newsTopicDAOImp=new NewsTopicDAOImp(conn);
        try{
            isDel=this.newsTopicDAOImp.deleteById(id);
        } catch(Exception e){
            throw e;
        }finally {
            if(this.conn!=null){
                this.conn.close();
            }
        }
        return isDel;
    }

    @Override
    public boolean doInsert(NewsTopic newsTopic) throws Exception {
        try {
            this.conn=new DatabaseConnection().getConnection();
        } catch (Exception e) {
            throw e;
        }
        this.newsTopicDAOImp=new NewsTopicDAOImp(this.conn);
        boolean isInsert=false;
        try{
            isInsert=this.newsTopicDAOImp.doInsert(newsTopic);
        } catch(Exception e){
            throw e;
        }finally {
            if(this.conn!=null){
                this.conn.close();
            }
        }
        return isInsert;
    }

    @Override
    public boolean doUpdate(NewsTopic newsTopic) throws Exception {
        boolean isUpdate=false;
        try {
            conn=new DatabaseConnection().getConnection();
        } catch (Exception e) {
            throw e;
        }
        this.newsTopicDAOImp=new NewsTopicDAOImp(conn);
        try{
            isUpdate=this.newsTopicDAOImp.doUpdate(newsTopic);
        } catch(Exception e){
            throw e;
        }finally {
            if(this.conn!=null){
                this.conn.close();
            }
        }
        return isUpdate;
    }
}
