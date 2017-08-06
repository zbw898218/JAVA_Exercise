package charles.news_manage.dao.Imp;

import charles.news_manage.dao.INewsTopicDAO;
import charles.news_manage.entity.NewsTopic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charles Zheng on 2017/8/2.
 */
public class NewsTopicDAOImp implements INewsTopicDAO {
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    public NewsTopicDAOImp(Connection conn){
        this.conn=conn;
    }
    @Override
    public List<NewsTopic> findAll(String keywords) throws Exception{
        String sql="select id,name,level from news_topic where  name like ?";
        List<NewsTopic> newsTopicList=new ArrayList<>();
        try {
            NewsTopic newsTopic=null;
            pst=this.conn.prepareStatement(sql);
            pst.setString(1,"%"+keywords+"%");
            rs=pst.executeQuery();
            while(rs.next()){
                newsTopic=new NewsTopic();
                newsTopic.setId(rs.getInt(1));
                newsTopic.setName(rs.getString(2));
                newsTopic.setLevel(rs.getInt(3));
                newsTopicList.add(newsTopic);
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            rs.close();
            pst.close();
        }
        return newsTopicList;
    }

    @Override
    public int findByName(String name) throws Exception{
        int id=0;
        String sql="select id from news_topic where name=?";
        try {
            pst=this.conn.prepareStatement(sql);
            pst.setString(1,name);
            rs=pst.executeQuery();
            if(rs.next()){
                id=rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            rs.close();
            pst.close();
        }
        return id;
    }

    @Override
    public boolean deleteById(int id) throws Exception{
        boolean flg=false;
        String sql="delete from news_topic where id=?";
        try {
            pst=this.conn.prepareStatement(sql);
            pst.setInt(1,id);
            if(pst.executeUpdate()>0){
                flg=true;
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            pst.close();
        }
        return flg;
    }

    @Override
    public boolean doInsert(NewsTopic newsTopic)throws Exception {
        boolean flag=false;
        //mysql news_topic(id)字段设置了自动增长，无需设置
        String sql="insert into news_topic(name,level) VALUES (?,?)";
        try{
            pst=this.conn.prepareStatement(sql);
            pst.setString(1,newsTopic.getName());
            pst.setInt(2,newsTopic.getLevel());
            if(pst.executeUpdate() > 0){
                flag=true;
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            pst.close();
        }
        return flag;
    }

    @Override
    public boolean doUpdate(NewsTopic newsTopic) throws Exception{
        boolean flg=false;
        String sql="UPDATE news_topic set name=?,level=? where id=?";
        try {
            pst=this.conn.prepareStatement(sql);
            pst.setInt(3,newsTopic.getId());
            pst.setString(1,newsTopic.getName());
            pst.setInt(2,newsTopic.getLevel());
            if(pst.executeUpdate() > 0){
                flg=true;
            }
        } catch (SQLException e) {
            throw e;
        }finally {
            pst.close();
        }
        return flg;
    }
}
