package com.charles.entity;

/**
 * 购买记录
 * Created by Charles on 2017/6/28
 */
public class Trade {
    private int buyTradeID;//购买交易id
    private int petID;//购买宠物ID
    private int price;//交易价格
    private int oldMasterID;//卖方id
    private int newMasterID;//买方id
    private int tradeType;//0.售卖 1.购买

    public Trade() {

    }
    
    public Trade(int petID, int price, int oldMasterID, int newMasterID, int tradeType) {
        this.petID = petID;
        this.price = price;
        this.oldMasterID = oldMasterID;
        this.newMasterID = newMasterID;
        this.tradeType = tradeType;
    }
    
    public Trade(int buyTradeID, int petID, int price, int oldMasterID, int newMasterID, int tradeType) {
        this.buyTradeID = buyTradeID;
        this.petID = petID;
        this.price = price;
        this.oldMasterID = oldMasterID;
        this.newMasterID = newMasterID;
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
    
    public int getOldMasterID() {
        return oldMasterID;
    }
    
    public void setOldMasterID(int oldMasterID) {
        this.oldMasterID = oldMasterID;
    }
    
    public int getNewMasterID() {
        return newMasterID;
    }
    
    public void setNewMasterID(int newMasterID) {
        this.newMasterID = newMasterID;
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
                ", oldMasterID=" + oldMasterID +
                ", newMasterID=" + newMasterID +
                ", tradeType=" + tradeType +
                '}';
    }
}
