package com.charles.JDBC;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 提供stm对象
 * Created by Charles on 2017/6/30
 */
public class MyStatement {
    public static Statement getStm(){
        Statement stm=null;
        Connection con=MyCon.getCon();

        try {

            stm=con.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stm;
    }
}
