package com.charles.bank.entity;

import java.util.Date;

/**银行卡基本信息表
 * Created by Administrator on 2017/7/18.
 */
public class BankCard {
    /**
     * cardID：卡id
     * accountID：账户id
     * subbranchID：开户行id
     * openCardTime：开卡时间
     * validity：过期时间
     */
    private int cardID;
    private int accountID;
    private int subbranchID;
    private Date openCardTime;
    private Date validity;

    public BankCard() {
    }

    public BankCard(int cardID, int accountID, int subbranchID, Date openCardTime, Date validity) {
        this.cardID = cardID;
        this.accountID = accountID;
        this.subbranchID = subbranchID;
        this.openCardTime = openCardTime;
        this.validity = validity;
    }

    public int getCardID() {
        return cardID;
    }

    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getSubbranchID() {
        return subbranchID;
    }

    public void setSubbranchID(int subbranchID) {
        this.subbranchID = subbranchID;
    }

    public Date getOpenCardTime() {
        return openCardTime;
    }

    public void setOpenCardTime(Date openCardTime) {
        this.openCardTime = openCardTime;
    }

    public Date getValidity() {
        return validity;
    }

    public void setValidity(Date validity) {
        this.validity = validity;
    }

    @Override
    public String toString() {
        return "银行卡基本信息{" +
                "cardID=" + cardID +
                ", accountID=" + accountID +
                ", subbranchID=" + subbranchID +
                ", openCardTime=" + openCardTime +
                ", validity=" + validity +
                '}';
    }
}
