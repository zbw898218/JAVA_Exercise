package com.charles.bank.entity;

/**银行基本表
 * Created by chaersi on 2017/7/17.
 */
public class BankInfo {
    /**
     * bankID:银行id
     * bankName：银行名称
     */
    private int bankID;
    private String bankName;

    public BankInfo() {
    }

    public BankInfo(int bankID, String bankName) {
        this.bankID = bankID;
        this.bankName = bankName;
    }

    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    @Override
    public String toString() {
        return "银行基本信息{" +
                "bankID=" + bankID +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
