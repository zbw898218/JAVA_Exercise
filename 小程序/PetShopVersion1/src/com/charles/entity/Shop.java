package com.charles.entity;

/**
 * 宠物商店
 * Created by Charles on 2017/6/27
 */
public class Shop extends User {
    private int shopID;
    private static final int SHOP_TYPE=0;
    public Shop() {
        super(SHOP_TYPE);
    }

    public Shop(int shopID) {
        super(SHOP_TYPE);
        this.shopID = shopID;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopID=" + shopID +
                '}';
    }
}
