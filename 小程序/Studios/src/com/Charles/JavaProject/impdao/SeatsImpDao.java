package com.Charles.JavaProject.impdao;

import com.Charles.JavaProject.dao.SeatsDao;
import com.Charles.JavaProject.entity.Films;
import com.Charles.JavaProject.entity.Schedule;
import com.Charles.JavaProject.entity.Seats;
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
public class SeatsImpDao implements SeatsDao {
    MyConnection myConnection=new MyConnection();
    @Override
    public List<Seats> selectSeats(Schedule schedule) {
        List<Seats> seatsList=new ArrayList<>();
        int videoHallID=schedule.getVideoHallID();
        Connection myCon=myConnection.getConnection();
        Seats seats=null;
        Statement stm=null;
        ResultSet rst=null;
        try {
            stm=myCon.createStatement();
            rst=stm.executeQuery(SQLTools.SELECT_SEATS);
            while(rst.next()){
                int videoHallIDs=rst.getInt(1);
                int  seatID=rst.getInt(2);
                int columnID=rst.getInt(3);
                int rowID=rst.getInt(4);
                int isSell=rst.getInt(5);
                if(videoHallID==videoHallIDs){
                    seats=new Seats(videoHallIDs,seatID,columnID,rowID,isSell);
                    seatsList.add(seats);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                myCon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return seatsList;
    }
    
    @Override
    public void updateSeats(Seats buySeat) {
        Connection myCon=myConnection.getConnection();
        Statement stm=null;
        String sql="update seats set isSell="+buySeat.getIsSell()+" where seatID="+buySeat.getSeatID();
        try {
            stm=myCon.createStatement();
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                myCon.commit();
                myCon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
    }
}
