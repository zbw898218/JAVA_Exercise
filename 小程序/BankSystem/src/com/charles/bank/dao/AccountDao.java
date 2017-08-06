package com.charles.bank.dao;

import com.charles.bank.entity.Account;

import java.util.List;

/**
 * 银行账户dao
 * Created by chaersi on 2017/7/18.
 */
public interface AccountDao {
    /**
     * 查询所有银行账户，以集合形式返回
     * @return
     */
    List<Account> selectAllAccount();

    /**
     * 新增银行账户，加入银行账户表
     * @param tmp
     */
    void addNewAccount(Account tmp);
}
