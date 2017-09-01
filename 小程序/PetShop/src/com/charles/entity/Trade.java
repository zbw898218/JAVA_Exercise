package com.charles.entity;

/**
 * 购买记录
 * Created by Charles on 2017/6/28
 */
public class Trade {
    private int buyTradeID;//购买交易id
    private int petID;//购买宠物ID
    private int price;//交易价格
    private int shopID;
    private int accountID;
    private int tradeType;//0.寄卖 1.购买

    public Trade() {

    }

    public Trade(int buyTradeID, int petID, int price, int shopID, int accountID, int tradeType) {
        this.buyTradeID = buyTradeID;
        this.petID = petID;
        this.price = price;
        this.shopID = shopID;
        this.accountID = accountID;
        this.tradeType = tradeType;
    }

    public int getBuyTradeID() {
        return buyTradeID;
    }

    public void setBuyTradeID(int buyTradeID) {
        this.buyTradeID = buyTradeID;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getShopID() {
        return shopID;
    }

    public void setShopID(int shopID) {
        this.shopID = shopID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getTradeType() {
        return tradeType;
    }

    public void setTradeType(int tradeType) {
        this.tradeType = tradeType;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "buyTradeID=" + buyTradeID +
                ", petID=" + petID +
                ", price=" + price +
                ", shopID=" + shopID +
                ", accountID=" + accountID +
                ", tradeType=" + tradeType +
                '}';
    }
}
