package com.charles.bank.entity;

/**管理员表
 * Created by chaersi on 2017/7/17.
 */
public class Manager {
    /**
     * managerID：管理员id
     * userID：用户id
     * managerLevel：管理员等级【1：超级管理员，2：普通管理员】
     */
    private int managerID;
    private int userID;
    private int managerLevel;

    public Manager() {
    }

    public Manager(int managerID, int userID, int managerLevel) {

        this.managerID = managerID;
        this.userID = userID;
        this.managerLevel = managerLevel;
    }

    public int getManagerID() {
        return managerID;
    }

    public void setManagerID(int managerID) {
        this.managerID = managerID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getManagerLevel() {
        return managerLevel;
    }

    public void setManagerLevel(int managerLevel) {
        this.managerLevel = managerLevel;
    }

    @Override
    public String toString() {
        return "管理员信息{" +
                "managerID=" + managerID +
                ", userID=" + userID +
                ", managerLevel=" + managerLevel +
                '}';
    }
}
