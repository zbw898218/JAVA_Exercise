package com.charles.tools;

import com.charles.entity.Pet;
import com.charles.service.PetService;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import static com.charles.service.PetService.selecetPetOnSell;

/**
 * 打印工具类：
 * 负责控制台打印信息，并接收用户控制台输入的信息格式化返回
 * Created by Charles on 2017/6/28
 */
public class PrintTools {
    static Scanner sc=new Scanner(System.in);

    /**
     * 打印首页
     * @return
     */
    public static int printIndex(){
        System.out.println("欢迎光临！");
        System.out.println("正在出售的宠物信息");
        List<Pet> pets=PetService.selecetPetOnSell();
        printList(pets);
        System.out.println("\n1.查询需要的宠物信息");
        System.out.println("2.注册");
        System.out.println("3.登录");
        System.out.println("4.退出");
        int check=sc.nextInt();
        return check;
    }

    /**
     * 遍历打印一个集合
     * @param tList
     * @param <T>
     */
    public static<T> void printList(List<T> tList){
        Iterator<T> it=tList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }

    /**
     * 获得登录的用户名和密码
     * @return
     */
    public static String[] getLoginInfo(){
        String[] str=new String[2];
        System.out.println("请输入用户名：");
        str[0]=sc.next();
        System.out.println("请输入密码：");
        str[1]=sc.next();
        return str;
    }
    public static String[] getRegInfo(){
        String[] str=new String[5];
        System.out.println("请输入注册账号类别[商家/顾客]：");
        str[0]=sc.next();
        System.out.println("请输入用户名：");
        str[1]=sc.next();
        System.out.println("请输入密码：");
        str[2]=sc.next();
        System.out.println("请输入年龄：");
        str[3]=sc.next();
        System.out.println("请输入充值金额：");
        str[4]=sc.next();
        return str;
    }

    /**
     *
     * @return
     */
    public static String getPetInfo(){
        System.out.println("请输入宠物的类型：");
        String str=sc.next();
        return str;
    }

    /**
     * 获得购买的宠物的信息
     * @return
     */
    public static int getBuyPetInfo(){
        System.out.println("输入需要购买的宠物ID");
        int petID=sc.nextInt();
        return petID;
    }
    public static int CustmanagerUI(){
        System.out.println("主人好！");
        System.out.println("1.购买宠物");
        System.out.println("2.出售宠物");
        System.out.println("3.退出");
        int check=sc.nextInt();
        return check;
    }
    public static int CommanagerUI(){
        System.out.println("主人好！");
        System.out.println("1.购买宠物");
        System.out.println("2.出售宠物");
        System.out.println("3.培育宠物");
        System.out.println("4.退出");
        int check=sc.nextInt();
        return check;
    }

    public static String[] getNewPetInfo(){
        String[] newPet=new String[4];
        System.out.println("请输入需要培育的宠物类型ID");
        newPet[0]=sc.next();
        System.out.println("请输入新宠物名称");
        newPet[1]=sc.next();
        System.out.println("请输入新宠物颜色");
        newPet[2]=sc.next();
        System.out.println("请输入新宠物价格");
        newPet[3]=sc.next();
        return newPet;
    }
}
