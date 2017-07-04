package JDBC;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.*;
import java.util.*;

/**
 * Created by Charles on 2017/6/23
 */
public class TestCon {
    private static String driver;
    private static String url;
    private static String userName;
    private static String passwrod;

    /**
 * 获取jdbc连接信息
 * @param file mysql数据库联系信息
 * @return HashMap<String,String> 返回mysql数据库联系信息组成的map集合
 * @throws Exception
 */
public static HashMap<String,String> getProperties(File file) throws Exception{
    HashMap<String,String> mysqlPro=new HashMap<String,String>();
    Properties pr=new Properties();
//    pr.list(System.out);
    pr.loadFromXML(new FileInputStream(file));
    Set<Object> keys=pr.keySet();
    Iterator<Object> it=keys.iterator();
    while(it.hasNext()){
        String key=(String)it.next();
        String value=pr.getProperty(key);
        mysqlPro.put(key,value);
    }
    return mysqlPro;
}
    /**
     * 设置jdbc连接信息
     * @param file
     * @throws Exception
     */
    public static void setProperties(File file) throws Exception{
        Scanner sc=new Scanner(System.in);
        Properties pr=new Properties();
        System.out.print("请指定驱动程序:");
        String driver=sc.next();
        System.out.print("请设置连接地址:");
        String url=sc.next();
        System.out.print("请输入用户名:");
        String userName=sc.next();
        System.out.print("请输入密码:");
        String password=sc.next();

        pr.setProperty("driver", driver);
        pr.setProperty("url", url);
        pr.setProperty("userName", userName);
        pr.setProperty("password", password);
        pr.storeToXML(new FileOutputStream(file), null);
    }

    public static void main(String[] args) throws Exception {
        File file=new File("e:/Mysql.xml");
        HashMap<String,String> mysqlPro=getProperties(file);

//        Iterator<Map.Entry<String,String>> iter=mysqlPro.entrySet().iterator();
//        while(iter.hasNext()){
//            Map.Entry<String,String> ent=iter.next();
//            String key=ent.getKey();
//            String value=ent.getValue();
//            System.out.println(key+"\t"+value);
//        }
        Statement stm=getConnect(mysqlPro);
        checkSql(stm);
        createTable(stm);
    }

    public static Statement getConnect(HashMap<String,String> mysqlPro) throws SQLException, ClassNotFoundException {
        driver=mysqlPro.get("driver");
        url=mysqlPro.get("url");
        userName=mysqlPro.get("userName");
        passwrod=mysqlPro.get("password");
//        System.out.println(driver+" "+url+" "+userName+" "+passwrod);
        Connection con=null;
        Statement stm=null;
        Class.forName(driver);
        try {

            con=DriverManager.getConnection(url,userName,passwrod);
            stm=con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stm;
    }
    /**
     * 查询
     */
    public static void checkSql(Statement stm){
        String sql="select * from teachers";
        try {
            ResultSet rst=stm.executeQuery(sql);
            while(rst.next()){
                int id=rst.getInt("id");
                String name=rst.getString("name");
                int age=rst.getInt("age");
                String pro=rst.getString("profession");
                System.out.println(id+"\t"+name+"\t"+age+"\t"+pro);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    /**
     * 创建表
     */
    public static void createTable(Statement stm){
        String sql="create TABLE student(\n" +
                " id int(11) not null auto_increment,\n" +
                " name VARCHAR(50),\n" +
                " age int(11),\n" +
                " PRIMARY KEY (`id`)\n" +
                " )ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;";

        try {
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateTable(Statement stm){
//        String sql="";
//        stm.
    }
}
