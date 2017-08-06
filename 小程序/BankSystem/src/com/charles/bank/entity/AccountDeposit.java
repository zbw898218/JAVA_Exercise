package com.charles.bank.entity;

/**账户存款类
 * Created by chaersi on 2017/7/17.
 */
public class AccountDeposit {
    /**
     * debitAccountID：借记账户iD【只有借记账户可以存款】
     * money：定期存款
     * depositTime：定期存款时间 ,按月累计，为整数月份
     */
    private int debitAccountID;
    private int depositTime;
    private double money;

    public AccountDeposit() {
    }

    public AccountDeposit(int debitAccountID, int depositTime, double money) {

        this.debitAccountID = debitAccountID;
        this.depositTime = depositTime;
        this.money = money;
    }

    public int getDebitAccountID() {
        return debitAccountID;
    }

    public void setDebitAccountID(int debitAccountID) {
        this.debitAccountID = debitAccountID;
    }

    public int getDepositTime() {
        return depositTime;
    }

    public void setDepositTime(int depositTime) {
        this.depositTime = depositTime;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "账户存款信息{" +
                "debitAccountID=" + debitAccountID +
                ", depositTime=" + depositTime +
                ", money=" + money +
                '}';
    }
}
