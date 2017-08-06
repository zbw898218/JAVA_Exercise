package com.charles.bank.Tools;

import com.charles.bank.entity.Account;
import com.charles.bank.entity.BankCustomer;
import com.charles.bank.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 打印工具类
 * Created by Administrator on 2017/7/18.
 */
public class PrintTools {
    static Scanner sc=new Scanner(System.in);
    static User user=null;

    /**
     * 获取控制台输入的登录信息，封装成user对象返回
     * @return
     */
    public static User getLoginInfo(){
        System.out.println("请输入用户名：");
        String userName=sc.next();
        System.out.println("请输入密码：");
        String userPwd=sc.next();
        user=new User();
        user.setUserName(userName);
        user.setUserPwd(userPwd);
        return user;
    }

    /**
     * 打印首页
     * @return
     */
    public static int printIndex(){
        System.out.println("-----------------欢迎光临---------------");
        System.out.println("\t\t1.用户注册");
        System.out.println("\t\t2.用户登录");
        System.out.println("\t\t3.退出");
        System.out.println("----------------------------------------");
        int check=sc.nextInt();
        return check;
    }

    /**
     * 获得注册信息，封装成user和customer对象，以集合形式返回
     * @return
     */
    public static List<User> getRegisterUser() {
        User user=new User();
        BankCustomer bc=new BankCustomer();
        List<User> list=new ArrayList<>();
        System.out.println("请输入用户名：");
        String userName=sc.next();
        System.out.println("请输入密码：");
        String userPwd=sc.next();
        System.out.println("请输入年龄：");
        int userage=sc.nextInt();
        System.out.println("请输入性别：");
        String usersex=sc.next();
        System.out.println("请输入地址：");
        String address=sc.next();
        System.out.println("请输入邮箱：");
        String email=sc.next();
        System.out.println("请输入电话：");
        String tel=sc.next();
        user.setUserName(userName);
        user.setUserSex(usersex);
        user.setUserPwd(userPwd);
        user.setUserAge(userage);
        bc.setAddress(address);
        bc.setEmail(email);
        bc.setTel(tel);
        list.add(user);
        list.add(bc);
        return list;
    }

    /**
     * 登录进入，管理界面
     * 功能：
     * 1.查询用户信息
     * 2.更新用户信息
     * 3.管理银行账户
     * 4.退出
     */
    public static int userManagerUI(){
        System.out.println("-------------用户管理界面---------------");
        System.out.println("1.查询用户信息");
        System.out.println("2.更新用户信息");
        System.out.println("3.管理银行账户");
        System.out.println("4.退出");
        System.out.println("----------------------------------------");
        int check=sc.nextInt();
        return check;
    }

    /**
     *接收控制台修改信息，封装成新的对象返回
     * @return
     */
    public static HashMap<Integer,String> updateUserInfo(){
        HashMap<Integer,String> chInfo=new HashMap<>();
        System.out.println("请选择要修改的信息：");
        while(true){
            System.out.print("1：用户名，2：密码，3：年龄，4：住址，5：邮箱，6：联系电话");
            int check=sc.nextInt();
            if(check==1){
                System.out.println("请输入新的用户名");
                chInfo.put(1,sc.next());
            }else if(check==2){
                System.out.println("请输入新的密码");
                chInfo.put(2,sc.next());
            }
            else if(check==3){
                System.out.println("请输入新的年龄");
                chInfo.put(3,sc.next());
            }
            else if(check==4){
                System.out.println("请输入新的住址");
                chInfo.put(4,sc.next());
            }
            else if(check==5){
                System.out.println("请输入新的邮箱");
                chInfo.put(5,sc.next());
            }
            else if(check==6){
                System.out.println("请输入新的联系电话");
                chInfo.put(6,sc.next());
            }
            System.out.println("结束：n 继续：y");
            if(sc.next().equals('n')){
                break;
            }
        }
        return chInfo;
    }

    /**
     * 用户银行账户管理界面
     * 功能：
     * 1.查询账号信息
     * 2.开通储蓄账户/信用账户
     * 3.借记卡取款
     * 4.借记卡存款
     * 5.信用卡消费
     * 6.信用卡还款
     * param check:用户选项
     */
    public static int accountManagerUI(){
        int check=0;
        System.out.println("-------------银行账户管理界面---------------");
        System.out.println("1.查询账号信息");
        System.out.println("2.开通储蓄账户/信用账户");
        System.out.println("3.借记卡取款");
        System.out.println("4.借记卡存款");
        System.out.println("5.信用卡消费");
        System.out.println("6.信用卡还款");
        System.out.println("7.退出");
        System.out.println("--------------------------------------------");
        check=sc.nextInt();
        return check;
    }

    /**
     * 控制台获取需要开通账户的银行名称和账户类型，数组形式返回
     * @return
     */
    public static String[] chooseWhichAccount(){
        String[] accInfo=new String[2];
        System.out.println("1.请输入要开通账户的银行名称【工、农、建、招】");
        accInfo[0]=sc.next();
        System.out.println("1.请输入要开通的账户类型【1：借记卡 2：信用卡】");
        accInfo[1]=sc.next();
        return accInfo;
    }
}
