package com.charles.bank.entity;

/**账户基本表
 * Created by chaersi on 2017/7/17.
 */
public class Account {
    /**
     * accountID:账户id
     * userID：用户id
     * bankID：银行id
     * accountTypeID:账户类型id
     * accountstatus：银行账户状态 1:正常，0：注销;
     */
    private int accountID;
    private int userID;
    private int bankID;
    private int accountTypeID;
    private int accountstatus=1;

    public Account() {
    }

    public Account(int accountID, int userID, int bankID ) {
        this.accountID = accountID;
        this.userID = userID;
        this.bankID = bankID;
    }

    public Account(int accountID, int userID, int bankID, int accountTypeID, int accountstatus) {
        this.accountID = accountID;
        this.userID = userID;
        this.bankID = bankID;
        this.accountTypeID = accountTypeID;
        this.accountstatus = accountstatus;
    }

    public Account(int accountID, int userID, int bankID, int accountstatus) {
        this.accountID = accountID;
        this.userID = userID;
        this.bankID = bankID;

        this.accountstatus = accountstatus;
    }

    public int getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(int accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public int getAccountstatus() {
        return accountstatus;
    }

    public void setAccountstatus(int accountstatus) {
        this.accountstatus = accountstatus;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    @Override
    public String toString() {
        return "账户基本信息{" +
                "accountID=" + accountID +
                ", userID=" + userID +
                ", bankID=" + bankID +
                ", accountTypeID=" + accountTypeID +
                ", accountstatus=" + accountstatus +
                '}';
    }


}
