//package Exercise.work0601;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Charles on 2017/6/1.
 */
public class Consumer {
    /**
     * Consumer:顾客类，提供顾客的账号，id等信息
     */
    private String account;
    private String password;
    private int card;//会员卡号，随机生成
//    提供账号，密码信息，构造顾客对象
    public Consumer(String account, String password) {
        this.account = account;
        this.password = password;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public String getAccount() {
        return account;
    }
    
    public void setAccount(String account) {
        this.account = account;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
//    自定义顾客信息打印方法
    @Override
    public String toString() {
        String st1="用户名"+"\t密码"+"\t会员卡号\n";
        String st2=account+"\t"+password+"\t\t"+card;
        return st1+st2;
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Consumer)) return false;
        
        Consumer consumer = (Consumer) o;
    
        return account != null ? account.equals(consumer.account) : consumer.account == null;
    }
    
    @Override
    public int hashCode() {
        return account != null ? account.hashCode() : 0;
    }
}
