package com.charles.bank.JDBC;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 提供
 * Created by Administrator on 2017/7/18.
 */
public class GetConnection {
    private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
    private static String userName="scott";
    private static String password="tiger";
    private static String driver="oracle.jdbc.OracleDriver";

    /**
     * 调用连接池方法，获取连接池对象，调用getConnection（）方法获得数据库连接
     * @return
     */
    public static Connection getCon(){
        Connection con=null;
        try {
            con=getPool().getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    /**
     * 设置连接池并返回，连接池对象
     * @return
     */

    public static Connection getCon1(){
        Connection con=null;
        try {
            Class.forName(driver);
            con= DriverManager.getConnection(url,userName,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return con;

    }
    private static ComboPooledDataSource getPool(){
        ComboPooledDataSource cds=new ComboPooledDataSource();
        //设置参数
        try {
            cds.setDriverClass(driver);
            cds.setJdbcUrl(url);
            cds.setUser(userName);
            cds.setPassword(password);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        //设置连接池参数
        cds.setInitialPoolSize(20);
        cds.setMaxPoolSize(100);
        cds.setCheckoutTimeout(5000);

        return cds;
    }
}
