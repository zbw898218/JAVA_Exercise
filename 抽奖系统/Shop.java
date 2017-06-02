//package Exercise.work0601;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/**
 * Created by Charles on 2017/6/1.
 */
public class Shop {
//    Shop：代表商家系统
//    pool：每个存储元素代表一个注册用户，包括用户名和密码。设置用户卡号
    static ArrayList<Consumer> pool=new ArrayList<Consumer>();
    static Iterator<Integer> iter=PrintClass.makeCard().iterator();
    private boolean answer=false;
    private Consumer con;
//  预存部分已注册账号
    static {
        pool.add(new Consumer("张三","123456"));
        pool.add(new Consumer("李四","123456"));
        pool.add(new Consumer("王五","123456"));
        pool.add(new Consumer("孙六","123456"));
        pool.add(new Consumer("赵奇","123456"));
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    //    提供一个注册方法，返回一个布尔值，注册成功，返回true
    public boolean sumFun(String[] str){
//        submit标记为是否可注册
        boolean submit=true;
        con=new Consumer(str[0],str[1]);
//        判断用户名是否被注册，如果被注册，将注册状态标记为false
        for(Consumer c:pool){
            if(c.getAccount().equals(str[0])){
                submit=false;
                System.out.println("用户名已被注册！请更换...");
                break;
            }
        }
//        如果是可注册状态，从生成的卡号集合中抽出一个卡号给注册用户，并将卡号从集合中删去
        if(submit){
            if(iter.hasNext()){
                int card=iter.next();
                iter.remove();
                con.setCard(card);
                pool.add(con);
                System.out.println("注册成功！请记好您的会员卡号");
                System.out.println(con);
            }else{
                submit=false;
                System.out.println("暂时不可注册！");
            }
        }
        return submit;
    }
    public Consumer loginF(Consumer con){
        Consumer c=null;
//        answer：标记登录状态

        for(Consumer x:pool){
            if(x.getAccount().equals(con.getAccount())&&x.getPassword().equals(con.getPassword())){
                c=x;
//                将登录状态改成true
                this.setAnswer(true);
                System.out.print("登陆成功！");
                break;
            }
        }
        if(!this.isAnswer()){
            System.out.print("用户名或密码不对，请重试！");
        }
        return c;
    }
    
}
