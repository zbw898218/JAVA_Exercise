package com.charles.bank.service;

import com.charles.bank.ImpDao.BankCustomerImpDao;
import com.charles.bank.dao.BankCustomerDao;
import com.charles.bank.entity.BankCustomer;

import java.util.Iterator;
import java.util.List;

/**
 * 顾客逻辑类
 * Created by Administrator on 2017/7/18.
 */
public class BankCustomerService {
    BankCustomerDao bcd=new BankCustomerImpDao();

    /**
     * 新顾客信息写入顾客信息表中
     * @param bc
     */
    public void registerNewCustomer(BankCustomer bc){
        List<BankCustomer> bcList=bcd.selectAllCustomer();
        int cid=0;
        if(bcList ==null){
            cid=1;
        }else{
            cid=bcList.get(bcList.size()-1).getCustomerID()+1;
        }
        bc.setCustomerID(cid);
        bcd.addNewCustomer(bc);
    }

    /**
     * 查询指定用户id的顾客信息，以顾客对象返回
     * @param userID
     * @return
     */
    public BankCustomer selectCustomer(int userID){
        BankCustomer bc=null;
        List<BankCustomer> bcList=bcd.selectAllCustomer();
        Iterator<BankCustomer> iter=bcList.iterator();
        while(iter.hasNext()){
            BankCustomer tmp=iter.next();
            if(tmp.getUserID()==userID){
                bc=tmp;
                break;
            }
        }
        return bc;
    }

    public void updateCustomerInfo(BankCustomer bc) {
        bcd.updateCustomerInfo(bc);
    }
}
