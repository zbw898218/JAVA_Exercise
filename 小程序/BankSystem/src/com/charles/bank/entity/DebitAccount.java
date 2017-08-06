package com.charles.bank.entity;


/**借记账户表：
 * Created by chaersi on 2017/7/17.
 */
public class DebitAccount extends Account  {
    /**
     *debitAccountID:借记卡id
     * accountID：账户id
     * balance：活期余额 默认0
     */
    private int debitAccountID;
    private int accountID;
    private double balance=0;


    public DebitAccount() {
    }

    public DebitAccount(int debitAccountID, int accountID, double balance) {
        this.debitAccountID = debitAccountID;
        this.accountID = accountID;
        this.balance = balance;
    }

    public int getDebitAccountID() {
        return debitAccountID;
    }

    public void setDebitAccountID(int debitAccountID) {
        this.debitAccountID = debitAccountID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "借记卡账户信息{" +
                "debitAccountID=" + debitAccountID +
                ", accountID=" + accountID +
                ", balance=" + balance +
                '}';
    }
}
