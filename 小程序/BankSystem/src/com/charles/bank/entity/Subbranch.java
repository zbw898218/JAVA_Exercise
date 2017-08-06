package com.charles.bank.entity;

/**分行信息表
 * Created by chaersi on 2017/7/17.
 */
public class Subbranch {
    /**
     * subBranchID：分行id
     * bankID：银行id
     * subBranchName：分行名称
     * address：分行地址
     * tel：分行电话
     */
    private int subBranchID;
    private int bankID;
    private String subBranchName;
    private String address;
    private String tel;

    public Subbranch() {
    }

    public Subbranch(int subBranchID, int bankID, String subBranchName, String address, String tel) {
        this.subBranchID = subBranchID;
        this.bankID = bankID;
        this.subBranchName = subBranchName;
        this.address = address;
        this.tel = tel;
    }

    public int getSubBranchID() {
        return subBranchID;
    }

    public void setSubBranchID(int subBranchID) {
        this.subBranchID = subBranchID;
    }

    public int getBankID() {
        return bankID;
    }

    public void setBankID(int bankID) {
        this.bankID = bankID;
    }

    public String getSubBranchName() {
        return subBranchName;
    }

    public void setSubBranchName(String subBranchName) {
        this.subBranchName = subBranchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "分行基本信息{" +
                "subBranchID=" + subBranchID +
                ", bankID=" + bankID +
                ", subBranchName='" + subBranchName + '\'' +
                ", address='" + address + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
