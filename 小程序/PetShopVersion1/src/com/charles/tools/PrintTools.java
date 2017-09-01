package com.charles.tools;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * 接收控制台输入信息的工具类
 * Created by Charles on 2017/6/27
 */
public class PrintTools {
    /**
     * 获取控制台输入的登录信息
     * @return
     */
    static Scanner sc=new Scanner(System.in);
    public static String[] getLoginInfo(){
        String[] loginInfo=new String[2];
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名：");
        loginInfo[0]=sc.next();
        System.out.println("请输入密码：");
        loginInfo[1]=sc.next();
        return loginInfo;
    }
    public  static int getRegisterType(){
        int type=0;
        System.out.println("请输入注册类别[商家/顾客]：");
        String str=sc.next();
        if(str.equals("商家")){
            type=0;
        }else if(str.equals("顾客")){
            type=1;
        }else{
            type=-1;
        }
        return type;
    }
    /**
     * 获取控制台输入的用户注册信息
     */
    public static String[] getRegisterInfo(){
        String[] RegisterInfo=new String[4];
        System.out.println("请输入用户名：");
        RegisterInfo[0]=sc.next();
        System.out.println("请输入密码：");
        RegisterInfo[1]=sc.next();
        System.out.println("请输入金额：");
        RegisterInfo[2]=sc.next();
        System.out.println("请输入注册地址：");
        RegisterInfo[3]=sc.next();
        return RegisterInfo;
    }
    
    public static int printIndex(){
        System.out.println("*********欢迎进入Charles的宠物商城************");
        System.out.println("\t\t1.注册");
        System.out.println("\t\t2.登录");
        System.out.println("\t\t3.退出");
        int fcheck=sc.nextInt();
        return fcheck;
    }
    
    public static int printManagerUI(){
        System.out.println("*********欢迎进入Charles的宠物商城************");
        System.out.println("\t\t1.查询商家信息");
        System.out.println("\t\t2.查询宠物信息");
        System.out.println("\t\t3.购买宠物");
        System.out.println("\t\t4.出售宠物");
        System.out.println("\t\t5.退出");
        int check=sc.nextInt();
        return check;
    }
    /**
     * 遍历集合并打印输出
     */
    public static <T> void printList(List<T> tList){
        Iterator<T> it=tList.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
