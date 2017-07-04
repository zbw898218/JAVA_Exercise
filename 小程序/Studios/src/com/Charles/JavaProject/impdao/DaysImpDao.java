package com.Charles.JavaProject.impdao;

import com.Charles.JavaProject.dao.DaysDao;
import com.Charles.JavaProject.entity.Days;
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
public class DaysImpDao implements DaysDao {
    MyConnection myConnection=new MyConnection();
    @Override
    public List<Days> selectDays() {
        List<Days> daysList=new ArrayList<>();
        Connection myCon=myConnection.getConnection();
        Statement stm=null;
        ResultSet rst=null;
        try {
            stm=myCon.createStatement();
            rst=stm.executeQuery(SQLTools.SELECT_DAYS);
            Days days=null;
            while(rst.next()){
                int dayID=rst.getInt(1);
                String dayName=rst.getString(2);
                days=new Days(dayID,dayName);
                daysList.add(days);
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
        return daysList;
    }
}
