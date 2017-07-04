package com.charles.entity;

/**
 * 交易类
 * Created by Charles on 2017/6/27
 */
public class Trade {
    private int tradeID;//交易编号
    private int petID;//交易宠物ID
    private int userID1;//买方ID
    private int userID2;//卖方ID
    private int money;//交易金额
//    private int tradeType;//1:买；0：卖
    private static final int BUY_TYPE=1;
    private static final int SELL_TYPE=0;

    public Trade() {
    }

    public Trade(int tradeID, int petID, int userID1, int userID2, int money) {
        this.tradeID = tradeID;
        this.petID = petID;
        this.userID1 = userID1;
        this.userID2 = userID2;
        this.money = money;
//        this.tradeType = tradeType;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public int getUserID1() {
        return userID1;
    }

    public void setUserID1(int userID1) {
        this.userID1 = userID1;
    }

    public int getUserID2() {
        return userID2;
    }

    public void setUserID2(int userID2) {
        this.userID2 = userID2;
    }

    public int getTradeID() {
        return tradeID;
    }

    public void setTradeID(int tradeID) {
        this.tradeID = tradeID;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    

    public static int getBuyType() {
        return BUY_TYPE;
    }

    public static int getSellType() {
        return SELL_TYPE;
    }

    @Override
    public String toString() {
        return "Trade{" +
                "tradeID=" + tradeID +
                ", petID=" + petID +
                ", userID1=" + userID1 +
                ", userID2=" + userID2 +
                ", money=" + money +
                '}';
    }
}
