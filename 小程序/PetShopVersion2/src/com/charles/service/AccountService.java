package com.charles.service;

import com.charles.dao.AccountDao;
import com.charles.entity.Account;
import com.charles.entity.Pet;
import com.charles.entity.Trade;
import com.charles.tools.IOTools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.util.Iterator;
import java.util.List;

/**
 * 账号逻辑类
 * 提供校验用户名和密码等账号信息的方法
 * Created by Charles on 2017/6/28
 */
public class AccountService {
    public static Account checkLoginInfo(String[] loginInfo){
        Account account=null;
        List<Account> accountList= AccountDao.selectAccounts();
        Iterator<Account> it=accountList.iterator();
        while(it.hasNext()){
            Account accounts=it.next();
            //校验用户名和密码。一致返回该账号对象
            if(accounts.getAccountName().equals(loginInfo[0])&&accounts.getAccountPwd().equals(loginInfo[1])){
                account=accounts;
                break;
            }
        }

        return account;
    }

    /**
     * 账户购买宠物
     * 1.扣除账户金额,并写入账户表
     * 2.修改宠物属性，并写入宠物对象表
     * 3.生成交易信息返回
     * @param pet
     * @return
     */
    public static void buyPet(Account account,Pet pet){
        List<Account> accountList= AccountDao.selectAccounts();
        accountList.remove(account);//删除原账户
        account.setAccountBalance(account.getAccountBalance()-pet.getPrice());//扣除购买花费
        accountList.add(account);//将变化后的账户重新加入账户表并写入
        AccountDao.updateAccount(accountList);

//        return trade;
    }
}
