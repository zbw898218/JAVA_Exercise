package Exercise.DVDSystem;

import java.util.Scanner;

/**
 * 辅助类：
 * 控制台打印和接收信息
 *
 * Created by Charles on 2017/6/16
 */
public class PrintTool{
    static Scanner input=new Scanner(System.in);
    /**
     * 打印首页信息。
     * @return ：返回用户的选择
     */
    public static int index(){
        System.out.println("***************欢迎来到Charles\'s 的音像店********");
        System.out.println("\t\t\t1.注册");
        System.out.println("\t\t\t2.登录");
        System.out.println("\t\t\t3.退出");
        System.out.println("************************************************");
        System.out.print("请输入您的选择：");
        int choice=input.nextInt();
        return choice;
    }
    /**
     * 打印用户选择注册类型的信息，接收并返回用户的选项
     * @return 返回用户选择注册的用户类型
     */
    public static int registerCheck(){
        System.out.println("\t\t\t1.普通用户注册");
        System.out.println("\t\t\t2.VIP用户注册");
        System.out.println("\t\t\t3.返回登录页面");
        System.out.print("请输入您的选择：");
        int choice=input.nextInt();
        return choice;
    }
    /**
     * 获取普通用户注册信息
     * @return 返回用户名和密码组成的String数组
     */
    public static String[] getInfo(){
        String[] info=new String[2];
        System.out.print("请输入您的用户名：");
        info[0]=input.next();
        System.out.print("请输入您的密码：");
        info[1]=input.next();
        return info;
    }
    /**
     * 获取VIP用户注册信息
     * @return 用户名、密码和充值金额组成的String数组
     */
    public static String[] getVipInfo(){
        String[] info=new String[3];
        System.out.print("请输入您的用户名：");
        info[0]=input.next();
        System.out.print("请输入您的密码：");
        info[1]=input.next();
        System.out.print("请输入您的充值金额：");
        info[2]=input.next();
        return info;
    }
    /**
     * 获取用户登录信息
     * @return 返回控制台接收的用户名和密码，以数组形式返回
     */
    public static String[] getLoginInfo(){
        String[] loginInfo=new String[2];
        System.out.print("请输入用户名：");
        loginInfo[0]=input.next();
        System.out.print("请输入密码：");
        loginInfo[1]=input.next();
        return loginInfo;
    }
    /**
     * 打印顾客登录后操作界面，接收并返回顾客操作选择
     * @return 返回顾客选项
     */


    public static int customerGUI(){
//        System.out.println("*********欢迎进入Charles\'s 的音像店*********");
        System.out.println("\t\t1.租借dvd");
        System.out.println("\t\t2.归还dvd");
        System.out.println("\t\t3.查看dvd");
        System.out.println("\t\t4.退出\n");
        System.out.print("请输入您的选择：");
        int check=input.nextInt();
        return check;
    }
    public static int adminGUI(){
//        System.out.println("*********欢迎进入Charles\'s 的音像店*********");
        System.out.println("\n\t\t1.新增dvd");
        System.out.println("\t\t2.删除dvd");
        System.out.println("\t\t3.查看dvd");
        System.out.println("\t\t4.退出\n");
        System.out.print("请输入您的选择：");
        int check=input.nextInt();
        return check;
    }

    /**
     * 接收用户控制台输入的要租借的DVD名称
     * @return 返回要租借的dvd名称
     */
    public static String loanDVDName(){
        System.out.print("请输入您要租借的dvd名称：");
        String dvdName=input.next();
        return dvdName;
    }
    /**
     * 定义一个管理员的查看dvd列表的方法，被删除的对象也会展示
     */
    public static void printAdminDVDList(){
//        System.out.println("*********欢迎进入Charles\'s 的音像店*********");
        for(DVD dvd:DataCenter.dvdList ){
            if(dvd !=null){
                System.out.println(dvd);
            }
        }
    }

    /**
     * 定义一个顾客的查看dvd列表的方法，被删除的对象不会展示
     */
    public static void printCustomerDVDList(){
        for(DVD dvd:DataCenter.dvdList ){
            if(dvd !=null&&dvd.getIsDel()!=1){
                System.out.println(dvd);
            }
        }
    }

    /**
     * 获取管理员设置的新增dvd名称和租金组成的数组
     * @return 返回新增dvd的名称和租金组成的数组
     */
    public static String[] getAddDVDInfo(){
        String[] info=new String[2];
//        System.out.println("*********欢迎进入Charles\'s 的音像店*********");
        System.out.print("请输入新增dvd的名称：");
        info[0]=input.next();
        System.out.print("请输入新增dvd的租金：");
        info[1]=input.next();
        return info;
    }

    public static String getDelDVDName(){
//        System.out.println("*********欢迎进入Charles\'s 的音像店*********");
        System.out.print("请输入需要删除的dvd的名称：");
        String name=input.next();
        return name;
    }

    /**
     * 返回角色进入操作页面的状态选项
     * @return check:1。继续 ；2.退出
     */
    public static int getStatus(){
//        System.out.println("*********欢迎进入Charles\'s 的音像店*********");
        System.out.println("\n1. 继续");
        System.out.println("2. 退出");
        System.out.print("请输入您的选择：");
        int check=input.nextInt();
        return check;
    }
}
