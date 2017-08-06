package com.charles.bank.entity;

/**用户类型表
 * Created by chaersi on 2017/7/17.
 */
public class UserType {
    /**
     * userTypeID:用户类型id
     * userTypeName：用户类型名称 【1：manager 2：vip 3：normal】
     */
    private int userTypeID;
    private String userTypeName;

    public UserType() {
    }

    public UserType(int userTypeID, String userTypeName) {
        this.userTypeID = userTypeID;
        this.userTypeName = userTypeName;
    }

    public int getUserTypeID() {
        return userTypeID;
    }

    public void setUserTypeID(int userTypeID) {
        this.userTypeID = userTypeID;
    }

    public String getUserTypeName() {
        return userTypeName;
    }

    public void setUserTypeName(String userTypeName) {
        this.userTypeName = userTypeName;
    }

    @Override
    public String toString() {
        return "用户类型{" +
                "userType=" + userTypeID +
                ", userTypeName='" + userTypeName + '\'' +
                '}';
    }
}
