package com.charles.entity;

/**
 * 商城的注册商家
 * Created by Charles on 2017/6/28
 */
public class Commerce {
    private int commerceID;//商家id
    private String commerceName;
    private String commercePwd;
    private int money;//商家注册资金

    public Commerce() {
    }

    public Commerce(int commerceID, String commerceName, String commercePwd, int money) {
        this.commerceID = commerceID;
        this.commerceName = commerceName;
        this.commercePwd = commercePwd;
        this.money = money;
    }

    public int getCommerceID() {
        return commerceID;
    }

    public void setCommerceID(int commerceID) {
        this.commerceID = commerceID;
    }

    public String getCommerceName() {
        return commerceName;
    }

    public void setCommerceName(String commerceName) {
        this.commerceName = commerceName;
    }

    public String getCommercePwd() {
        return commercePwd;
    }

    public void setCommercePwd(String commercePwd) {
        this.commercePwd = commercePwd;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Commerce{" +
                "commerceID=" + commerceID +
                ", commerceName='" + commerceName + '\'' +
                ", commercePwd='" + commercePwd + '\'' +
                ", money=" + money +
                '}';
    }
}
