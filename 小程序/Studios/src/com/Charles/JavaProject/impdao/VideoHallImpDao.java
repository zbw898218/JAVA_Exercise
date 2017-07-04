package com.Charles.JavaProject.impdao;

import com.Charles.JavaProject.dao.VideoHallDao;
import com.Charles.JavaProject.entity.VideoHall;
import com.Charles.JavaProject.jdbc.MyConnection;
import com.Charles.JavaProject.tools.SQLTools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Charles on 2017/7/2.
 */
public class VideoHallImpDao implements VideoHallDao {
    MyConnection myConnection=new MyConnection();
    @Override
    public List<VideoHall> selectVideoHalls() {
        List<VideoHall> videoHallList=new ArrayList<>();
        Connection myCon=myConnection.getConnection();
        Statement stm=null;
        ResultSet rst=null;
        try {
            stm=myCon.createStatement();
            rst=stm.executeQuery(SQLTools.SELECT_VIDEOHALL);
            VideoHall videoHall=null;
            while(rst.next()){
                int cinemaID=rst.getInt(1);
                int videoHallID=rst.getInt(2);
                String videoHallName=rst.getString(3);
                videoHall=new VideoHall(cinemaID,videoHallID,videoHallName);
                videoHallList.add(videoHall);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rst.close();
                stm.close();
                myCon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return videoHallList;
    }
}
