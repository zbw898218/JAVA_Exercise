package com.charles.bank.entity;

/**用户基本表
 * Created by chaersi on 2017/7/17.
 */
public class User {
    /**
     * userID:用户id
     * userTypeID：用户类型id
     * userName：用户名
     * userPwd:用户密码
     * userAge：用户年龄
     * userSex：用户性别
     * usercreditlevel:用户信用等级 默认1：最低
     * userstatus:用户状态 1：正常（默认） 0：注销
     */
    private int userID;
    private int userTypeID;
    private String userName;
    private String userPwd;
    private int userAge;
    private String userSex;
    private int usercreditlevel=1;
    private int userstatus=1;

    public User() {

    }

    public User(int userID, int userTypeID, String userName, String userPwd, int userAge, String userSex, int usercreditlevel, int userstatus) {
        this.userID = userID;
        this.userTypeID = userTypeID;
        this.userName = userName;
        this.userPwd = userPwd;
        this.userAge = userAge;
        this.userSex = userSex;
        this.usercreditlevel = usercreditlevel;
        this.userstatus = userstatus;
    }

    public User(int userID, int userTypeID, String userName, String userPwd, int userAge, String userSex) {

        this.userID = userID;
        this.userTypeID = userTypeID;
        this.userName = userName;
        this.userPwd=userPwd;
        this.userAge = userAge;
        this.userSex = userSex;
    }

    public int getUsercreditlevel() {
        return usercreditlevel;
    }

    public void setUsercreditlevel(int usercreditlevel) {
        this.usercreditlevel = usercreditlevel;
    }

    public int getUserstatus() {
        return userstatus;
    }

    public void setUserstatus(int userstatus) {
        this.userstatus = userstatus;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getUserTypeID() {
        return userTypeID;
    }

    public void setUserTypeID(int userTypeID) {
        this.userTypeID = userTypeID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserAge() {
        return userAge;
    }

    public void setUserAge(int userAge) {
        this.userAge = userAge;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    @Override
    public String toString() {
        return "用户基本信息{" +
                "userID=" + userID +
                ", userTypeID=" + userTypeID +
                ", userName='" + userName + '\'' +
                ", userPwd='" + userPwd + '\'' +
                ", userAge=" + userAge +
                ", userSex='" + userSex + '\'' +
                ", usercreditlevel=" + usercreditlevel +
                ", userstatus=" + userstatus +
                '}';
    }
}
