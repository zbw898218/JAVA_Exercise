package com.Charles.JavaProject.jdbc;

import java.sql.Connection;
//import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Charles on 2017/7/2.
 */
public class MyConnection {
    public Connection getConnection(){
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/studio?serverTimezone=UTC&amp&characterEncoding=utf-8";
        String userName="root";
        String password="898218";
        Connection connection=null;
        try {
            Class.forName(driver);
            connection= DriverManager.getConnection(url,userName,password);
            //关闭自动提交事务
            connection.setAutoCommit(false);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    
}
