package com.Charles.JavaProject.service;

import com.Charles.JavaProject.dao.AccountDao;
import com.Charles.JavaProject.entity.Account;
import com.Charles.JavaProject.impdao.AccountImpDao;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * 账户逻辑类
 * Created by Charles on 2017/7/2.
 */
public class AccountService {
    AccountDao accountImpDao=new AccountImpDao();
    
    /**
     * 增加用户注册信息校验
     * @param accountInfo 用户信息（账户名和密码）数组
     * @return 返回注册获得AccountID
     */
    public int register(String[] accountInfo){
        int accountID=0;
        List<Account> accountList=accountImpDao.selectAll();
        boolean flg=true;
        Iterator<Account> it=accountList.iterator();
        while(it.hasNext()){
            Account tmp=it.next();
            if(tmp.getAccountName().equals(accountInfo[0])){
                flg=false;
                break;
            }
        }
        if(flg){
            Account account=new Account(accountInfo[0],accountInfo[1]);
            accountID=accountImpDao.register(account);
        }
        return accountID;
    }
    
    /**
     * 登陆方法，遍历查询获得的账户列表集合，校验用户名与密码，返回用户账户id
     * @param accountInfo
     * @return
     */
    public int login(String[] accountInfo){
        int accountID=0;
        List<Account> accountList=accountImpDao.selectAll();
        Iterator<Account> it=accountList.iterator();
        while(it.hasNext()){
            Account tmp=it.next();
            if(tmp.getAccountName().equals(accountInfo[0])&&tmp.getAccountPwd().equals(accountInfo[1])){
                accountID=tmp.getAccountID();
                break;
            }
        }
        return accountID;
    }
    
    /**
     * 查询账户信息方法
     * @param accountID 账户id
     * @return
     */
    public Account selectAccount(int accountID){
        List<Account> accountList=accountImpDao.selectAll();
        Account account=null;
        Iterator<Account> it=accountList.iterator();
        while(it.hasNext()){
            Account tmp=it.next();
            if(tmp.getAccountID()==accountID){
                account=tmp;
            }
        }
        return account;
    }
    
    public void updateAccountBalance(int accountID,int accountBalance) {
        
        Account account=selectAccount(accountID);
        account.setAccountBalance(accountBalance);
        accountImpDao.updateAccount(account);
    }
}
