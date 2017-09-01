package com.Charles.JavaProject.tools;

import com.Charles.JavaProject.entity.Seats;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 打印工具类
 * Created by Charles on 2017/7/2.
 */
public class PrintTools {
    static Scanner sc=new Scanner(System.in);
    public static void printIndex(){
        System.out.println("*****************Charles电影商城********************");
        System.out.println("\t\t\t\t\t1.\t注册");
        System.out.println("\t\t\t\t\t2.\t登陆");
        System.out.println("\t\t\t\t\t3.\t退出");
        System.out.println("*****************************************************");
        
    }
    /**
     * 获取注册信息的方法
     * @return
     */
    public static String[] getRegInfo(){
        String[] regInfo=new String[2];
        try{
            System.out.print("请输入账号：");
            regInfo[0]=sc.next();
            System.out.print("请输入密码：");
            regInfo[1]=sc.next();
            System.out.print("请再次输入密码：");
            String pwd=sc.next();
            if(!regInfo[1].equals(pwd)){
                System.out.println("密码不一致！");
                regInfo=null;
            }
        }catch (Exception e){
            System.out.print("输入错误！"+e.getMessage());
        }
        return regInfo;
    }
    
    /**
     *获得登陆信息的方法
     * @return
     */
    public static String[] getLoginInfo() {
        String[] loginInfo=new String[2];
        try {
            System.out.print("请输入账号：");
            loginInfo[0] = sc.next();
            System.out.print("请输入密码：");
            loginInfo[1] = sc.next();
        }catch (Exception e){
            System.out.print("输入错误！"+e.getMessage());
        }
        return loginInfo;
    }
    public static int firstCheck() {
        int check=0;
        System.out.print("请选择：");
        try{
            check=sc.nextInt();
        }catch (Exception e){
            System.out.print("选择错误！"+e.getMessage());
        }
        return check;
    }
    public static void managerUI(){
        System.out.println("*****************Charles电影商城********************");
        System.out.println("\t\t\t\t\t1.\t查询电影院");
        System.out.println("\t\t\t\t\t2.\t查询上映电影");
        System.out.println("\t\t\t\t\t3.\t查询指定电影");
        System.out.println("\t\t\t\t\t4.\t购买电影票");
        System.out.println("\t\t\t\t\t5.\t退出");
        System.out.println("*****************************************************");
    }
    
    /**
     *管理页面获得选项
     * @return
     */
    public static int secondCheck() {
        int check=0;
        System.out.print("请选择：");
        check=sc.nextInt();
        return check;
    }
    
    public  static String selectFilmName(){
        System.out.print("请输入要查询的电影名");
        String filmName=sc.next();
        return filmName;
    }
    
    /**
     * 获取要购买的电影票信息
     * @return
     */
    public static String[] getBuyTicketInfo(){
        String[] buyInfo=new String[4];
        try{
            System.out.print("请输入电影名: ");
            buyInfo[0]=sc.next();
            System.out.print("请输入选择的电影院: ");
            buyInfo[1]=sc.next();
            System.out.print("请输入观影日期: ");
            buyInfo[2]=sc.next();
            System.out.print("请输入观影时段:　");
            buyInfo[3]=sc.next();
        }catch (Exception e){
            System.out.print("输入错误:"+e.getMessage());
            buyInfo=null;
        }
        return buyInfo;
    }
    
    
    /**
     * 获得选择的座位
     * @return
     */
    public static int[] getBuySeatInfo(){
        int[] seats=new int[2];
        try {
            System.out.print("请输入第几排[1-5]:　");
            seats[0]=sc.nextInt();
            System.out.print("请输入第几列[1-5]:　");
            seats[1]=sc.nextInt();
        }catch (Exception e){
            System.out.print("输入错误！"+e.getMessage());
            seats=null;
        }
        return seats;
    }
    /**
     * 打印电影票信息
     * @param seatsList
     * @return
     */
    public static void printBuyTicket(List<Seats> seatsList){
        Iterator<Seats> st=seatsList.iterator();
        while(st.hasNext()){
            Seats seats=st.next();
            if(seats.getIsSell()==0){
                System.out.println("第 "+seats.getColumnID()+" 排"+" 第"+seats.getRowID()+" 列"+" 可以购买");
            }else{
                System.out.println("第 "+seats.getColumnID()+" 排"+" 第"+seats.getRowID()+" 列"+" 已经售出");
            }
            
        }
    }
    
    /**
     * 确认购买信息
     * @return
     */
    public static boolean checkBuyChoose() {
        System.out.print("是否确认购买？[Y/N]");
        String st=sc.next();
        boolean flg=false;
        if(st.equals("Y")||st.equals("y")||st.equals("是")){
            flg=true;
        }
        return flg;
    }
}
