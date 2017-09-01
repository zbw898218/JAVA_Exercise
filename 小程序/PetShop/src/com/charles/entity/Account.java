package com.charles.entity;

/**
 * 废弃！
 * 商城账户表
 * 负责管理用户账户，提供注册登录支持
 * Created by Charles on 2017/6/28
 */
public class Account {
    private int accountID;
    private String accountName;
    private String accountPwd;
    private int accountBalance;

    public Account() {
    }

    public Account(int accountID, String accountName, String accountPwd, int accountBalance) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.accountPwd = accountPwd;
        this.accountBalance = accountBalance;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPwd() {
        return accountPwd;
    }

    public void setAccountPwd(String accountPwd) {
        this.accountPwd = accountPwd;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountID=" + accountID +
                ", accountName='" + accountName + '\'' +
                ", accountPwd='" + accountPwd + '\'' +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
