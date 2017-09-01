package com.charles.ConnectPool;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 * Created by Charles on 2017/7/3
 */
public class MyPool {
    private static String driver="com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/studio?serverTimezone=UTC&amp&characterEncoding=utf-8";
    private static String userName="root";
    private static String password="898218";
    private LinkedList<Connection> conList=new LinkedList<>();
    private int initSize=3;
    private int maxSize=5;
    private int currentSize=0;//记录当前可用连接数

    //加载的时候自动注册驱动
    static {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public MyPool(){
        for(int i=0;i<initSize;i++){
            conList.add(this.getCon());
            currentSize++;
        }
    }
    /**
     * 获得连接方法
     * @return
     */
    private Connection getCon(){
            try {
                final Connection con=DriverManager.getConnection(url,userName,password);
                //动态代理，重写close方法
                Connection myCon=(Connection) Proxy.newProxyInstance(
                        MyPool.class.getClassLoader(),//类加载器，只要在同一个JDK中的类即可
                        new Class[]{Connection.class},//要代理的接口的集合
                        //编写一个方法处理器
                        new InvocationHandler(){
                            @Override
                            public Object invoke(Object proxy, Method method, Object[] args)
                                    throws Throwable {
                                Object value=null;
                                //当遇到close方法，就会把对象放回连接池中，而不是关闭连接
                                if(method.getName().equals("close")){
                                    conList.addLast(con);
                                }else{
                                    value=method.invoke(con,args);
                                }
                                return value;
                            }
                        }
                );
                return myCon;
            } catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
    }
    /**
     * 从连接池中获取连接
     */
    public Connection getConFormPool(){
        Connection connection=null;
        if(conList.size()>0){
            connection=conList.removeFirst();
        }else if(conList.size()==0&&currentSize<maxSize){
            //连接池被拿空，且连接数没有达到上限，创建新的连接
            conList.addLast(this.getCon());
            currentSize++;
            connection=conList.removeFirst();
        }else{
            System.out.println("抱歉！");
        }

        return connection;
    }
    /**
     * 释放连接
     * @param con
     */
    public void releaseCon(Connection con){
        conList.addLast(con);
    }
}
