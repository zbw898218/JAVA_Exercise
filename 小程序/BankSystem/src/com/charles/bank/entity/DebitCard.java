package com.charles.bank.entity;

/**
 * 借记卡基本信息
 * Created by Administrator on 2017/7/18.
 */
public class DebitCard extends BankCard{
    /**
     * debitCardID：借记卡id
     * cardID：卡id
     * cardName：卡名称
     */
    private int debitCardID;
    private int cardID;
    private String cardName;

    public DebitCard() {
    }

    public DebitCard(int debitCardID, int cardID, String cardName) {
        this.debitCardID = debitCardID;
        this.cardID = cardID;
        this.cardName = cardName;
    }

    public int getDebitCardID() {
        return debitCardID;
    }

    public void setDebitCardID(int debitCardID) {
        this.debitCardID = debitCardID;
    }

    @Override
    public int getCardID() {
        return cardID;
    }

    @Override
    public void setCardID(int cardID) {
        this.cardID = cardID;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }

    @Override
    public String toString() {
        return "借记卡基本信息{" +
                "debitCardID=" + debitCardID +
                ", cardID=" + cardID +
                ", cardName='" + cardName + '\'' +
                '}';
    }
}
