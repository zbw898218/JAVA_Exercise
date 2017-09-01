package com.charles.ConnectPool;


import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Charles on 2017/7/3
 */
public class MyPoolTest {
    public static void main(String[] args) throws SQLException {
        MyPool myPool=new MyPool();
        for(int i=0;i<11;i++){

            Connection con=myPool.getConFormPool();
            if(i==4){

                myPool.releaseCon(con);
            }else if(i%2!=0){
                con.close();
            }
            System.out.println(con.toString());
        }

    }
}
