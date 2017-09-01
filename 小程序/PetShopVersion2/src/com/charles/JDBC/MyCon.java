package com.charles.JDBC;
import java.io.*;
import java.sql.*;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

/**
 * 提供数据库的连接对象connection
 * Created by Charles on 2017/6/29
 */
public class MyCon {
    public static Connection getCon(){
        File file=new File("mysql.properties");
        Connection con=null;
        Properties mysqlPro=new Properties();
        try{
            BufferedReader br=new BufferedReader(new FileReader(file));
            mysqlPro.load(br);
            String driver = "com.mysql.jdbc.Driver";//mysqlPro.getProperty("driver");
            String url=mysqlPro.getProperty("url");
            String userName=mysqlPro.getProperty("userName");
            String password=mysqlPro.getProperty("password");
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection(url,userName,password);

            con.setAutoCommit(false);
//            System.out.println(url);
//            BufferedOutputStream bw=new BufferedOutputStream(new FileOutputStream("mysql.xml"));
//            mysqlPro.storeToXML(bw,null);
        }catch(FileNotFoundException e){

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}
