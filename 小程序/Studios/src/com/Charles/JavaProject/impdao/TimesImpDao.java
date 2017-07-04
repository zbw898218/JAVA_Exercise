package com.Charles.JavaProject.impdao;

import com.Charles.JavaProject.dao.TimesDao;
import com.Charles.JavaProject.entity.Schedule;
import com.Charles.JavaProject.entity.Times;
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
public class TimesImpDao implements TimesDao {
    MyConnection myConnection=new MyConnection();
    @Override
    public List<Times> selectTimes() {
        List<Times> timesList=new ArrayList<>();
        Connection myCon=myConnection.getConnection();
        Statement stm=null;
        ResultSet rst=null;
        try {
            stm=myCon.createStatement();
            rst=stm.executeQuery(SQLTools.SELECT_TIMES);
            Times times=null;
            while(rst.next()){
                int timeID=rst.getInt(1);
                String timeName=rst.getString(2);
                times=new Times(timeID,timeName);
                timesList.add(times);
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
        return timesList;
    }
}
