package com.Charles.JavaProject.impdao;

import com.Charles.JavaProject.dao.ScheduleDao;
import com.Charles.JavaProject.entity.Account;
import com.Charles.JavaProject.entity.Schedule;
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
public class ScheduleImpDao implements ScheduleDao {
    MyConnection myConnection=new MyConnection();
    @Override
    public List<Schedule> selectSchedules() {
        List<Schedule> scheduleList=new ArrayList<>();
        Connection myCon=myConnection.getConnection();
        Statement stm=null;
        ResultSet rst=null;
        try {
            stm=myCon.createStatement();
            rst=stm.executeQuery(SQLTools.SELECT_SCHEDULE);
            Schedule schedule=null;
            while(rst.next()){
                int cinemaID=rst.getInt(1);
                int videoHallID=rst.getInt(2);
                int dayID=rst.getInt(3);
                int timeID=rst.getInt(4);
                int filmID=rst.getInt(5);
                schedule=new Schedule(cinemaID,videoHallID,dayID,timeID,filmID);
                scheduleList.add(schedule);
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
        return scheduleList;
    }
}
