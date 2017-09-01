package charles.news_manage.util;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by Charles Zheng on 2017/8/2.
 */
public class DatabaseConnection{
    private static final String DRIVER="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/java_web?useSSL=true&serverTimezone=UTC&amp&characterEncoding=utf-8";
    private static final String USERNAME="root";
    private static final String PASSWORD="898218";
    private Connection conn=null;

    public DatabaseConnection() throws Exception{
        Class.forName(DRIVER);
        this.conn= DriverManager.getConnection(URL,USERNAME,PASSWORD);
    }

    public Connection getConnection(){
        return this.conn;
    }


}