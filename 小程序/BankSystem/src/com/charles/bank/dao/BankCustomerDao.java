package com.charles.bank.dao;

import com.charles.bank.entity.BankCustomer;

import java.util.List;

/**
 * 顾客DAO
 * Created by Administrator on 2017/7/18.
 */
public interface BankCustomerDao {
    /**
     * 查询所有顾客信息
     * @return
     */
    List<BankCustomer> selectAllCustomer();

    /**
     * 新增顾客记录
     * @param bc
     */
    void addNewCustomer(BankCustomer bc);

    /**
     * 更新顾客信息
     * @param bc
     */
    void updateCustomerInfo(BankCustomer bc);
}
