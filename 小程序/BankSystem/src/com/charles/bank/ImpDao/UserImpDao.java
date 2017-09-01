package com.charles.bank.ImpDao;

import com.charles.bank.JDBC.GetConnection;
import com.charles.bank.Tools.GET_SQL;
import com.charles.bank.dao.UserDao;
import com.charles.bank.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */
public class UserImpDao implements UserDao {
    @Override
    public List<User> selectAllUser() {
        List<User> userList=new ArrayList<>();
        Connection con= GetConnection.getCon();
        PreparedStatement ps=null;
        ResultSet rs=null;
        User user=null;
        try {
            ps=con.prepareStatement(GET_SQL.SQL_SELECT_BANKUSER);
            rs=ps.executeQuery();
            while(rs.next()){
                user=new User();
                user.setUserID(rs.getInt(1));
                user.setUserTypeID(rs.getInt(2));
                user.setUserName(rs.getString(3));
                user.setUserPwd(rs.getString(4));
                user.setUserAge(rs.getInt(5));
                user.setUserSex(rs.getString(6));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return userList;
        }
    }


    @Override
    public void addNewUser(User user) {
        Connection con= GetConnection.getCon();
        PreparedStatement ps=null;
        try {
            ps=con.prepareStatement(GET_SQL.SQL_INSERT_BANKUSER);
            ps.setInt(1,user.getUserID());
            ps.setInt(2,user.getUserTypeID());
            ps.setString(3,user.getUserName());
            ps.setString(4,user.getUserPwd());
            ps.setInt(5,user.getUserAge());
            ps.setString(6,user.getUserSex());
            ps.setInt(7,user.getUserstatus());
            ps.setInt(8,user.getUsercreditlevel());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void updateUserInfo(User user) {
        Connection con= GetConnection.getCon();
        PreparedStatement ps=null;
        try {
            ps=con.prepareStatement(GET_SQL.SQL_UPDATE_BANKUSER);
            ps.setString(1,user.getUserName());
            ps.setString(2,user.getUserPwd());
            ps.setInt(3,user.getUserAge());
            ps.setInt(4,user.getUserID());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
