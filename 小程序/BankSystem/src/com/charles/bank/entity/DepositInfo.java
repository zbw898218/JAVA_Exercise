package com.charles.bank.entity;

/**存款信息表
 * Created by Administrator on 2017/7/18.
 */
public class DepositInfo {
    /**
     * depositID：存款信息id
     * debitCardID：借记卡id
     * money：存款金额
     * depositTime：存款时间
     */
    private int depositID;
    private int debitCardID;
    private double money;
    private int depositTime;

    public DepositInfo() {
    }

    public DepositInfo(int depositID, int debitCardID, double money, int depositTime) {
        this.depositID = depositID;
        this.debitCardID = debitCardID;
        this.money = money;
        this.depositTime = depositTime;
    }

    public int getDepositID() {
        return depositID;
    }

    public void setDepositID(int depositID) {
        this.depositID = depositID;
    }

    public int getDebitCardID() {
        return debitCardID;
    }

    public void setDebitCardID(int debitCardID) {
        this.debitCardID = debitCardID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getDepositTime() {
        return depositTime;
    }

    public void setDepositTime(int depositTime) {
        this.depositTime = depositTime;
    }

    @Override
    public String toString() {
        return "存款信息{" +
                "depositID=" + depositID +
                ", debitCardID=" + debitCardID +
                ", money=" + money +
                ", depositTime=" + depositTime +
                '}';
    }
}
