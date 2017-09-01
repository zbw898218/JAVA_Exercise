package com.charles.entity;

/**
 * 宠物商城，类似天猫
 *提供交易平台
 * Created by Charles on 2017/6/27
 */
public class Shop  {
    private int shopID;
    private String shopName;
    private int money;//注册资金
    private String address;

    public Shop() {
    }

    public Shop(int shopID, String shopName, int money, String address) {
        this.shopID = shopID;
        this.shopName = shopName;
        this.money = money;
        this.address = address;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopID=" + shopID +
                ", shopName='" + shopName + '\'' +
                ", money=" + money +
                ", address='" + address + '\'' +
                '}';
    }
}
