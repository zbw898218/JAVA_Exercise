package com.charles.bank.service;

import com.charles.bank.ImpDao.DebitAccountImpDao;
import com.charles.bank.dao.DebitAccountDao;
import com.charles.bank.entity.DebitAccount;

import java.util.List;

/**
 * 借记卡类
 * Created by chaersi on 2017/7/18.
 */
public class DebitAccountService {
    DebitAccountDao debitAccountDao=new DebitAccountImpDao();
    public void insertNewAccount(DebitAccount tmp1) {
        List<DebitAccount> debitAccountList=debitAccountDao.selectAllDebitAccount();
        int deid=0;
        if(debitAccountList==null){
            deid=1;
        }else{
            deid=debitAccountList.get(debitAccountList.size()-1).getDebitAccountID()+1;
        }
        tmp1.setDebitAccountID(deid);
        debitAccountDao.addNewDebitAccount(tmp1);
    }
}
