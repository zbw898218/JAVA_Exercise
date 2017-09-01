package com.charles.ConnectPool;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import java.sql.Connection;

/**
 * 把参数数据写在一个名叫c3p0-config.xml的XML文件中，
 * 在创建C3P0对象时会自动在classpath去寻找该文件来读取~
 也就是说:c3p0会到classpath下读取名字为c3p0-config.xml文件
 * Created by Charles on 2017/7/3
 */
public class C3P0Test02 {
    public static void main(String[] args){
        try{
        ComboPooledDataSource cp = new ComboPooledDataSource("mysql");
        for(int i = 0 ; i<9 ; i++)
        {
            Connection conn = cp.getConnection();
            System.out.println(conn.hashCode());
            if(i==5)
            {
                conn.close();
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
