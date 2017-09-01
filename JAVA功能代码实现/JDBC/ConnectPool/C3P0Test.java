package com.charles.ConnectPool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *  C3P0是一个开源组织的产品，开源框架的内部的连接池一般都使用C3P0来实现，例如：Hibernate
 * Created by Charles on 2017/7/3
 */
/**
 * C3P0的用法和DBCP的用法非常的相似~这里不做累赘。
 特别的是C3PO读取参数文件的方式，C3P0除了能像DBCP那样读取配置文件，
 它还提供了一种特殊的设置参数的方式，就是把参数数据写在一个名叫c3p0-config.xml的XML文件中，
 在创建C3P0对象时会自动在classpath去寻找该文件来读取~
 也就是说:c3p0会到classpath下读取名字为c3p0-config.xml文件
 */
public class C3P0Test {
    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/studio?serverTimezone=UTC&amp&characterEncoding=utf-8";
    private static String userName="root";
    private static String password="898218";
    public static void main(String[] args){
        ComboPooledDataSource cds=new ComboPooledDataSource();
        //设置参数
        cds.setJdbcUrl(url);
        cds.setUser(userName);
        cds.setPassword(password);
        try {
            cds.setDriverClass(driver);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
        //设置连接池的参数
        cds.setInitialPoolSize(3);
        cds.setMaxPoolSize(5);
        cds.setCheckoutTimeout(1000);//最大等待时间
        for(int i = 0 ; i<8 ; i++)
        {
            Connection conn = null;
            try {
                conn = cds.getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            System.out.println(conn.hashCode());
        }


}
}
