//package Exercise.work0601;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by Charles on 2017/6/1.
 */
public class PrintClass {
    /**
     * PrintClass:工具类，提供一系列的控制台打印方法，以及接收返回用户的控制台输入信息
     */
    static Scanner input=new Scanner(System.in);
    /**
     *PrintClass:用于格式化打印
     */
//    提供一个生成存储不重复4位卡号的集合并返回
    public static HashSet<Integer> makeCard(){
        HashSet<Integer> cards = new HashSet<Integer>();
        while (cards.size() <= 100) {
            cards.add((int) (Math.random() * 9000 + 1000));//随机生成卡号
        }
        return cards;
    }
//     格式化打印存储幸运号码的序列luck方法
    public static void printLuck(HashSet<Integer> set) {
        Iterator<Integer> iter= set.iterator();
        while (iter.hasNext()) {
            System.out.print(iter.next()+" ");
        }
        System.out.println();
    }
    //    获得用户输入的卡号
    public static int getCard(){
        System.out.print("请输入您的卡号：");
        int card=input.nextInt();
        return card;
    }
//    随机生成幸运卡号,将中奖情况作为布尔值返回
    public static boolean getLuckCard(int num) {
        boolean answ=false;
        HashSet<Integer> cards = makeCard();
        HashSet<Integer> luck=new HashSet<Integer>();
        while (luck.size()<=5){
            int a=(int) (Math.random() * 9000 + 1000);
            if(cards.contains(a)){
                luck.add(a);
            }
        }
        System.out.println("本日的幸运数字为:");
        printLuck(luck);
        if (luck.contains(num)) {
            System.out.println("恭喜！您成为了本日的幸运会员！");
            answ=true;
        } else {
            System.out.println("抱歉！您不是本日的幸运会员！");
        }
        return answ;
    }
//    首页打印格式
    public static void printIndex(){
        System.out.println("************欢迎进入奖客富翁系统************");
        System.out.println("\t\t\t\t1.注册\t\t\t\t");
        System.out.println("\t\t\t\t2.登录\t\t\t\t");
        System.out.println("\t\t\t\t3.抽奖\t\t\t\t");
        System.out.println("*****************************************");
    }
//    返回顾客选择的菜单选项
    public static int consuCheck(){
            System.out.print("请选择菜单[1~3]：");
            int a=input.nextInt();
            if(a==1){
                System.out.println("[奖客富翁系统>注册]");
            }else if(a==2){
                System.out.println("[奖客富翁系统>登录]");
            }else{
                System.out.println("[奖客富翁系统>抽奖]");
            }
            return a;
    }
//    询问是否继续，返回一个布尔值，真，继续，假退出
    public static boolean consuCheck1(){
        boolean flg=false;
        System.out.print("继续吗？(y/n)");
        String s=input.next();
        if(s.toLowerCase().equals("y")){
            flg=true;
        }else {
            flg = false;
        }
        return flg;
    }
//    收集顾客注册信息，数组形式返回
    public static String[] submitFun(){
        String[] con=new String[2];
        System.out.print("请输入用户名:");
        con[0]=input.next();
        System.out.print("\n请输入密码:");
        con[1]=input.next();
        return con;
    }
//    收集顾客登陆信息方法，数组形式返回
    public static String[] loginFun(){
        String[] con=new String[2];
        System.out.print("请输入用户名:");
        con[0]=input.next();
        System.out.print("\n请输入密码:");
        con[1]=input.next();
        return con;
    }
    
   
}
