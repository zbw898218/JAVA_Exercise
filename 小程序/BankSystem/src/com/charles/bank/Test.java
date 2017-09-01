package com.charles.bank;

import com.charles.bank.Tools.PrintTools;
import com.charles.bank.entity.*;
import com.charles.bank.service.*;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 测试类
 * Created by Administrator on 2017/7/18.
 */
public class Test {
    UserService userService=new UserService();
    BankCustomerService bcs=new BankCustomerService();
    AccountService accountService=new AccountService();
    BankInfoService bankInfoService=new BankInfoService();
    DebitAccountService debitAccountService=new DebitAccountService();
    public static void main(String[] agrs){
        Test test=new Test();
        test.start();
    }

    /**
     * 首页，登录、注册等功能
     */
    public void start(){
        while(true){
            int check=PrintTools.printIndex();
            switch (check){
                case 1://注册
                    List<User> list=PrintTools.getRegisterUser();
                    User newUser=userService.registerNewUser(list.get(0));
                    if(newUser!=null){
                        BankCustomer bc=(BankCustomer)list.get(1);
                        bc.setUserID(newUser.getUserID());
                        bcs.registerNewCustomer(bc);
                        System.out.println("注册成功！");
                        userManagerUI(newUser);
                    }else{
                        System.out.println("用户名不可用，注册失败！");
                    }
                    break;
                case 2://登录
                    User user=userService.checkLoginInfo(PrintTools.getLoginInfo());
                    if(user!=null){
                        System.out.println("登录成功！");
                        userManagerUI(user);
                    }else{
                        System.out.println("用户名或密码错误！");
                    }
                    break;
                case 3://退出
                    System.out.println("谢谢，再见！");
                    System.exit(0);
                    break;
                default://错误输入
                    System.out.println("输入错误，请重新输入！");
                    break;
            }
        }
    }

    /**
     * 登录进入，管理界面
     * 功能：
     * 1.查询用户信息
     * 2.更新用户信息
     * 3.管理银行账户
     * 4.退出
     */
    public void userManagerUI(User user){
        int check=PrintTools.userManagerUI();
        BankCustomer bc=bcs.selectCustomer(user.getUserID());
        switch (check){
            case 1://1.查询用户信息
                System.out.println(user+" "+bc);
                break;
            case 2://2.更新用户信息
                boolean isUp=true;
                HashMap<Integer,String> chInfo=PrintTools.updateUserInfo();
                Iterator<Map.Entry<Integer,String>> it=chInfo.entrySet().iterator();
                String userName=null;
                String userpwd=null;
                String tel=null;
                while(it.hasNext()){
                    Map.Entry<Integer,String> ent=it.next();
                    int key=ent.getKey();
                    String value=ent.getValue();
                    if(key==1){
                        boolean isOK=userService.checkUserName(value);
                        if(isOK){
                            userName=value;
                        }else{
                            System.out.println("用户名不可用！");
                            isUp=false;
                            break;
                        }
                    }else if(key==2){
                        if(value !=null){
                            userpwd=value;
                        }else{
                            System.out.println("密码不能为空！");
                            isUp=false;
                            break;
                        }
                    }else if(key==3){
                        user.setUserAge(Integer.parseInt(value));
                    }else if(key==4){
                        bc.setAddress(value);
                    }else if(key==5){
                        bc.setEmail(value);
                    }else if(key==6){
                        if(value!=null){
                            tel=value;
                        }else{
                            System.out.println("电话不能为空！");
                            isUp=false;
                            break;
                        }
                    }
                }
                if(isUp){//isUp为真时才进行更新操作
                    user.setUserName(userName);
                    user.setUserPwd(userpwd);
                    bc.setTel(tel);
                    userService.updateUserInfo(user);
                    bcs.updateCustomerInfo(bc);
                    System.out.println("信息已更新！");
                    System.out.println(user+" "+bc);
                }else{
                    System.out.println("信息录入错误！");
                    System.out.println(user+" "+bc);
                }
                break;
            case 3://3.管理银行账户
                accountManagerUI(user.getUserID());
                break;
            case 4://退出
                System.out.println("谢谢，再见！");
                System.exit(0);
                break;
            default:
                break;
        }
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
     * @param userID
     */
    public void accountManagerUI(int userID){
        List<Account> accountList=accountService.getAllAccounts(userID);
        int check=PrintTools.accountManagerUI();
        switch (check){
            case 1://1.查询账号账单
                if(accountList==null){
                    System.out.println("对不起，您目前还没有开通任何银行账户！");
                }else{
                    Iterator<Account> its=accountList.iterator();
                    while(its.hasNext()){
                        System.out.println(its.next());
                    }
                }
                break;
            case 2://2.开通储蓄账户/信用账户
                String[] info=PrintTools.chooseWhichAccount();
                int bankid=bankInfoService.selectInfoByBankName(info[0]);
                if(bankid==-1){
                    System.out.println("您输入的开户银行名称不正确");
                }else{
                    int accountTypeID=Integer.parseInt(info[1]);
                    if(accountTypeID !=1||accountTypeID !=2){
                        System.out.println("您输入的账户类型不正确");
                    }else{
                        Account tmp=new Account();
                        tmp.setAccountTypeID(accountTypeID);
                        tmp.setBankID(bankid);
                        tmp.setUserID(userID);
                        Account newAccount=accountService.insertNewAccount(tmp);
                        if(accountTypeID==1){
                            DebitAccount tmp1=new DebitAccount();
                            tmp1.setAccountID(newAccount.getAccountID());
                            debitAccountService.insertNewAccount(tmp1);
                        }else{
                            CreditAccount tmp2=new CreditAccount();
                            tmp2.setAccountID(newAccount.getAccountID());
                            //生成新的信用卡账户，加入数据库
                        }
                    }
                }
                break;
            case 3://3.借记卡取款
                break;
            case 4://4.借记卡存款
                break;
            case 5://5.信用卡消费
                break;
            case 6://6.信用卡还款
                break;
            case 7://退出
                System.out.println("谢谢，再见！");
                System.exit(0);
                break;
            default://错误输入
                System.out.println("输入错误！");
                break;
        }
    }

}
