package com.charles.bank.entity;

import java.util.Date;

/**信用账户表
 * Created by chaersi on 2017/7/17.
 */
public class CreditAccount extends Account{
    /**
     * creditAccountID：信用账户id
     * accountID：账户id
     * creditLevel：信用等级
     * balance：账户余额
     * payDate：账单还款日期
     * overDue:逾期时间 月份
     */
    private int creditAccountID;
    private int accountID;
    private int creditLevel;
    private double balance;
    private Date payDate;
    private int overDue;


    public CreditAccount() {
    }

    public CreditAccount(int creditAccountID, int accountID, int creditLevel, double balance, Date payDate,int overDue) {
        this.creditAccountID = creditAccountID;
        this.accountID = accountID;
        this.creditLevel = creditLevel;
        this.balance = balance;
        this.payDate = payDate;
        this.overDue=overDue;
    }

    public int getCreditAccountID() {
        return creditAccountID;
    }

    public void setCreditAccountID(int creditAccountID) {
        this.creditAccountID = creditAccountID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(int creditLevel) {
        this.creditLevel = creditLevel;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Date getPayDate() {
        return payDate;
    }

    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }

    public int getOverDue() {
        return overDue;
    }

    public void setOverDue(int overDue) {
        this.overDue = overDue;
    }

    @Override
    public String toString() {
        return "信用账户信息{" +
                "creditAccountID=" + creditAccountID +
                ", accountID=" + accountID +
                ", creditLevel=" + creditLevel +
                ", balance=" + balance +
                ", payDate=" + payDate +
                ", overDue=" + overDue +
                '}';
    }
}
