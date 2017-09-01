package com.charles.bank.service;

import com.charles.bank.ImpDao.BankInfoImpDao;
import com.charles.bank.dao.BankInfoDao;
import com.charles.bank.entity.BankInfo;

import java.util.Iterator;
import java.util.List;

/**
 * 银行信息逻辑类
 * Created by chaersi on 2017/7/18.
 */
public class BankInfoService {
    BankInfoDao bidao=new BankInfoImpDao();

    /**
     * 根据银行名称查询银行id
     * @param bankName
     * @return
     */
    public int selectInfoByBankName(String bankName){
        List<BankInfo> bankInfoList=bidao.selectAllBanks();
        Iterator<BankInfo> iter=bankInfoList.iterator();
        int bankID=-1;
        while(iter.hasNext()){
            BankInfo tmp=iter.next();
            if(tmp.getBankName().contains(bankName)){
                bankID=tmp.getBankID();
                break;
            }
        }
        return bankID;
    }
}
