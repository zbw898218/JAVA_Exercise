package com.charles.bank.service;

import com.charles.bank.ImpDao.AccountImpDao;
import com.charles.bank.dao.AccountDao;
import com.charles.bank.entity.Account;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 账户逻辑类
 * Created by chaersi on 2017/7/18.
 */
public class AccountService {
    AccountDao acdao=new AccountImpDao();
    public List<Account> getAllAccounts(int userID){
        List<Account> accountList=acdao.selectAllAccount();
        List<Account> needList=new ArrayList<>();
        Iterator<Account> iter=accountList.iterator();
        while(iter.hasNext()){
            Account tmp=iter.next();
            if(tmp.getUserID()==userID){
                needList.add(tmp);
            }
        }
        return needList;
    }

    /**
     * 新增银行账户
     * @param tmp
     */
    public Account insertNewAccount(Account tmp) {
        List<Account> accountList=acdao.selectAllAccount();
        int accountID=0;
        if(accountList==null){
            accountID=1;
        }else{
            accountID=accountList.get(accountList.size()-1).getAccountID()+1;
        }
        tmp.setAccountID(accountID);
        acdao.addNewAccount(tmp);
        return tmp;
    }
}
