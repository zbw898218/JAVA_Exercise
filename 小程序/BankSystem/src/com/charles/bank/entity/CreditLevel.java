package com.charles.bank.entity;

/**信用等级表
 * Created by chaersi on 2017/7/17.
 */
public class CreditLevel {
    /**
     * creditLevel:信用等级
     * credits：信用额度
     */
    private int creditLevel;
    private int credits;

    public CreditLevel() {
    }

    public CreditLevel(int creditLevel, int credits) {
        this.creditLevel = creditLevel;
        this.credits = credits;
    }

    public int getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(int creditLevel) {
        this.creditLevel = creditLevel;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Override
    public String toString() {
        return "信用等级信息{" +
                "creditLevel=" + creditLevel +
                ", credits=" + credits +
                '}';
    }
}
