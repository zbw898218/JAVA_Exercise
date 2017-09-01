package com.charles.bank.entity;

/**逾期利率表
 * Created by Administrator on 2017/7/18.
 */
public class HirepurchaseInterest {
    /**
     * hirepurchaseTime：逾期时间【月数】
     * hirepurchaseRate：逾期利率
     */
    private int hirepurchaseTime ;
    private double hirepurchaseRate;

    public HirepurchaseInterest() {
    }

    public HirepurchaseInterest(int hirepurchaseTime, double hirepurchaseRate) {

        this.hirepurchaseTime = hirepurchaseTime;
        this.hirepurchaseRate = hirepurchaseRate;
    }

    public int getHirepurchaseTime() {
        return hirepurchaseTime;
    }

    public void setHirepurchaseTime(int hirepurchaseTime) {
        this.hirepurchaseTime = hirepurchaseTime;
    }

    public double getHirepurchaseRate() {
        return hirepurchaseRate;
    }

    public void setHirepurchaseRate(double hirepurchaseRate) {
        this.hirepurchaseRate = hirepurchaseRate;
    }

    @Override
    public String toString() {
        return "逾期利率信息{" +
                "hirepurchaseTime=" + hirepurchaseTime +
                ", hirepurchaseRate=" + hirepurchaseRate +
                '}';
    }
}
