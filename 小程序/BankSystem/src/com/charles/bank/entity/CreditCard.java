package com.charles.bank.entity;

/**
 * 信用卡基本信息
 * Created by Administrator on 2017/7/18.
 */
public class CreditCard extends BankCard{
    /**
     * creditcardID:信用卡id
     * cardID：卡id
     * cardName：卡名称
     */
    private int creditcardID;
    private int cardID;
    private String cardName;

    public CreditCard() {
    }

    public CreditCard(int creditcardID, int cardID, String cardName) {

        this.creditcardID = creditcardID;
        this.cardID = cardID;
        this.cardName = cardName;
    }

    public int getCreditcardID() {
        return creditcardID;
    }

    public void setCreditcardID(int creditcardID) {
        this.creditcardID = creditcardID;
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
        return "信用卡基本信息{" +
                "creditcardID=" + creditcardID +
                ", cardID=" + cardID +
                ", cardName='" + cardName + '\'' +
                '}';
    }
}
