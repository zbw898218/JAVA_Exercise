package com.charles.bank.dao;

import com.charles.bank.entity.DebitAccount;

import java.util.List;

/**
 * 借记卡Dao
 * Created by chaersi on 2017/7/18.
 */
public interface DebitAccountDao {
    /**
     * 新增借记卡账户
     * @param debitAccount
     */
    void addNewDebitAccount(DebitAccount debitAccount);

    List<DebitAccount> selectAllDebitAccount();
}
