package com.charles.entity;

/**
 * 主人表
 * Created by Charles on 2017/6/27
 */
public class Master {
    private int masterID;
    private String mastName;
    private String mastPwd;
    private int mastAge;
    private int masterType;//1:商家 2：顾客
    private int mastMoney;//主人资产

    public Master() {
    }

    public Master(int masterID, String mastName, String mastPwd, int mastAge, int masterType, int mastMoney) {
        this.masterID = masterID;
        this.mastName = mastName;
        this.mastPwd = mastPwd;
        this.mastAge = mastAge;
        this.masterType = masterType;
        this.mastMoney = mastMoney;
    }

    public int getMasterID() {
        return masterID;
    }

    public void setMasterID(int masterID) {
        this.masterID = masterID;
    }

    public String getMastName() {
        return mastName;
    }

    public void setMastName(String mastName) {
        this.mastName = mastName;
    }

    public String getMastPwd() {
        return mastPwd;
    }

    public void setMastPwd(String mastPwd) {
        this.mastPwd = mastPwd;
    }

    public int getMastAge() {
        return mastAge;
    }

    public void setMastAge(int mastAge) {
        this.mastAge = mastAge;
    }

    public int getMasterType() {
        return masterType;
    }

    public void setMasterType(int masterType) {
        this.masterType = masterType;
    }

    public int getMastMoney() {
        return mastMoney;
    }

    public void setMastMoney(int mastMoney) {
        this.mastMoney = mastMoney;
    }

    @Override
    public String toString() {
        return "Master{" +
                "masterID=" + masterID +
                ", mastName='" + mastName + '\'' +
                ", mastPwd='" + mastPwd + '\'' +
                ", mastAge=" + mastAge +
                ", masterType=" + masterType +
                ", mastMoney=" + mastMoney +
                '}';
    }
}
