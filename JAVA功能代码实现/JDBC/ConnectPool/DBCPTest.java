package com.charles.ConnectPool;

import org.apache.commons.dbcp.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;

/**DBCP连接池是开源组织Apache软件基金组织开发的连接池实现。
 事实上，tomcat服务器默认就会使用这个连接池道具。
 * Created by Charles on 2017/7/3
 */
public class DBCPTest {
    private static String driver="com.mysql.jdbc.Driver";
    private static String userName="root";
    private static String password="898218";
    public static void main(String[] args){
        //获得连接池对象
        BasicDataSource bs=new BasicDataSource();
        bs.setUrl("jdbc:mysql://localhost:3306/studio?serverTimezone=UTC&amp&characterEncoding=utf-8");
        bs.setUsername(userName);
        bs.setPassword(password);
        bs.setDriverClassName(driver);

        bs.setInitialSize(3);
        bs.setMaxActive(5);
        bs.setMaxWait(1000);//设置最大等待时间，单位毫秒
        //待到结束都没有连接被释放回连接池，就会出现报错。
        for(int i = 0 ; i<9;i++)
        {
            Connection conn = null;
            try {
                conn = bs.getConnection();
                System.out.println(conn.hashCode());
                if(i==5)
                {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
