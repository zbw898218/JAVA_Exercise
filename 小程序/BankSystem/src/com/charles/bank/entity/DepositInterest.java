package com.charles.bank.entity;

/**存款利率表
 * Created by chaersi on 2017/7/17.
 */
public class DepositInterest {
    /**
     * depositTime：存款时间，月为单位
     * interestRate：存款利率
     */
    private int depositTime;
    private double interestRate;

    public DepositInterest() {
    }

    public DepositInterest(int depositTime, double interestRate) {

        this.depositTime = depositTime;
        this.interestRate = interestRate;
    }

    public int getDepositTime() {
        return depositTime;
    }

    public void setDepositTime(int depositTime) {
        this.depositTime = depositTime;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public String toString() {
        return "存款利率信息{" +
                "depositTime=" + depositTime +
                ", interestRate=" + interestRate +
                '}';
    }
}
