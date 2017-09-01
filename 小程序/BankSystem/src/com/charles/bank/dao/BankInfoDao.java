package com.charles.bank.dao;

import com.charles.bank.entity.BankInfo;

import java.util.List;

/**
 * 银行类dao
 * Created by chaersi on 2017/7/18.
 */
public interface BankInfoDao {
    /**
     * 查询所有可以开通账户的银行基本信息，以集合形式返回
     * @return
     */
    List<BankInfo> selectAllBanks();
}
