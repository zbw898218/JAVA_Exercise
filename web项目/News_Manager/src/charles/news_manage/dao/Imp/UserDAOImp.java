package charles.news_manage.dao.Imp;

import charles.news_manage.dao.IUserDAO;
import charles.news_manage.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Charles Zheng on 2017/8/2.
 */
public class UserDAOImp implements IUserDAO {
    private Connection conn;
    private PreparedStatement pst;
    private ResultSet rs;
    public UserDAOImp(Connection conn){
        this.conn=conn;
    }
    @Override
    public boolean findByUser(User user) throws Exception{
        boolean flg=false;
        String sql="SELECT id,level from news_user where username=? and password=?";
        try {
            pst=this.conn.prepareStatement(sql);
            pst.setString(1,user.getUsername());
            pst.setString(2,user.getPassword());
            rs=pst.executeQuery();
            if(rs.next()){
                user.setId(rs.getInt(1));
                user.setLevel(rs.getInt(2));
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
    public boolean doInsert(User user) throws Exception {
        boolean flag=false;
        String sql="insert into news_user(username,password,level) VALUES (?,?,?)";
        try{
            pst=this.conn.prepareStatement(sql);
            pst.setString(1,user.getUsername());
            pst.setString(2,user.getPassword());
            pst.setInt(3,user.getLevel());
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
    public boolean doUpdate(User user) throws Exception {
        boolean flag=false;
        String sql="UPDATE news_user set username=? where id=?";
        try{
            pst=this.conn.prepareStatement(sql);
            pst.setString(1,user.getUsername());

            pst.setInt(2,user.getId());
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
}
