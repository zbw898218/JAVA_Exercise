package com.Charles.JavaProject.impdao;

import com.Charles.JavaProject.dao.CinemaDao;
import com.Charles.JavaProject.entity.Cinema;
import com.Charles.JavaProject.jdbc.MyConnection;
import com.Charles.JavaProject.tools.SQLTools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 电影院实现类
 * Created by Charles on 2017/7/2.
 */
public class CinemaImpDao implements CinemaDao {
    MyConnection myConnection=new MyConnection();
    
    /**
     * 查询电影院表单信息，以集合形式返回
     * @return
     */
    public List<Cinema> selectCinemas() {
        List<Cinema> cinemaList=new ArrayList<>();
        Connection myCon=myConnection.getConnection();
        Cinema cinema=null;
        Statement stm=null;
        ResultSet rst=null;
        try {
            stm=myCon.createStatement();
            rst=stm.executeQuery(SQLTools.SELECT_CINEMA);
            while(rst.next()){
                int cinemaID=rst.getInt(1);
                String cinemaName=rst.getString(2);
                String cinemaAddress=rst.getString(3);
                cinema=new Cinema(cinemaID,cinemaName,cinemaAddress);
                cinemaList.add(cinema);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cinemaList;
    }
    
    @Override
    public int newCinema(Cinema cinema) {
        List<Cinema> cinemaList=selectCinemas();
        Connection myCon=myConnection.getConnection();
        int cinemaID=0;
        if(cinemaList.size()==0){
            cinemaID=1;
        }else{
            cinemaID=cinemaList.get(cinemaList.size()-1).getCinemaID()+1;
        }
        String cinemaName=cinema.getCinemaName();
        String cinemaAddress=cinema.getCinemaAddress();
        int cinemaMoney=cinema.getCinemaMoney();
        PreparedStatement pst=null;
        try {
            myCon.setAutoCommit(false);//关闭自动提交事务
            pst=myCon.prepareStatement(SQLTools.INSERT_CINEMA);
            pst.setInt(1,cinemaID);
            pst.setString(2,cinemaName);
            pst.setString(3,cinemaAddress);
            pst.setInt(4,cinemaMoney);
            pst.addBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pst.executeBatch();
                myCon.commit();
                myCon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return cinemaID;
    }
}
