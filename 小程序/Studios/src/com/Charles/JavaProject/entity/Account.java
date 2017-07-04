package com.Charles.JavaProject.entity;

/**
 * 商城账户类
 * Created by Charles on 2017/7/1.
 */
public class Account {
    /**
     * accountID：账户id
     * accountName：账户姓名
     * accountPwd：账户密码
     * accountType:账户类型 1：影院管理员 2：普通顾客
     * accountBalance：账户余额
     */
    private int accountID;
    private String accountName;
    private String accountPwd;
    private int accountType;
    private int accountBalance;
    
    public Account(String accountName, String accountPwd) {
        this.accountName = accountName;
        this.accountPwd = accountPwd;
    }
    
    public Account(int accountID, String accountName, String accountPwd, int accountType, int accountBalance) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.accountPwd = accountPwd;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }
    
    public Account(int accountID, String accountName, String accountPwd, int accountBalance) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.accountPwd = accountPwd;
        this.accountBalance = accountBalance;
    }
    
    public Account() {
    
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
    
    public int getAccountType() {
        return accountType;
    }
    
    public void setAccountType(int accountType) {
        this.accountType = accountType;
    }
    
    @Override
    public String toString() {
        return "账户信息{" +
                "accountID=" + accountID +
                ", accountName='" + accountName + '\'' +
                ", accountPwd='" + accountPwd + '\'' +
                ", accountType=" + accountType +
                ", accountBalance=" + accountBalance +
                '}';
    }
}
