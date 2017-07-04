package com.charles.entity;

/**
 * 用户类
 * Created by Charles on 2017/6/27
 */
public class User {
    private int ID;//用户id
    private int userType;//用户类型：0.商家 1.顾客
    private String userName;
    private String userPwd;
    private int money;
    private String address;
    private int isDel;//0：正常 1：被删除了
    public User() {
    }

    public User(int userType) {
        this.userType = userType;
    }

    public User(String userName, String userPwd) {
        this.userName = userName;
        this.userPwd = userPwd;
    }

    public User(int ID, int userType, String userName, String userPwd, int money, String address) {
        this.ID = ID;
        this.userType = userType;
        this.userName = userName;
        this.userPwd = userPwd;
        this.money = money;
        this.address = address;
    }
    
    public User(int userType, String userName, String userPwd, int money, String address) {
        this.userType = userType;
        this.userName = userName;
        this.userPwd = userPwd;
        this.money = money;
        this.address = address;
    }
    
    public int getIsDel() {
        return isDel;
    }
    
    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }
    
    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }
    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        String str="";
        if(userType==1){
            str="Customer{" +
                    "ID=" + ID +
                    ", userType=" + userType +
                    ", userName='" + userName + '\'' +
                    ", userPwd='" + userPwd + '\'' +
                    ", money=" + money +
                    ", address='" + address + '\'' +
                    '}';
        }else{
            str="Shop{" +
                    "ID=" + ID +
                    ", userType=" + userType +
                    ", userName='" + userName + '\'' +
                    ", userPwd='" + userPwd + '\'' +
                    ", money=" + money +
                    ", address='" + address + '\'' +
                    '}';
        }
        return str;
    }
}
