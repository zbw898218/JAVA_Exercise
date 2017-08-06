package com.charles.bank.entity;

/**顾客表
 * Created by chaersi on 2017/7/17.
 */
public class Customer {
    /**
     * customerID：顾客id
     * userID：用户id
     * address：顾客地址
     * email：顾客邮箱
     * tel：顾客电话
     */
    private int customerID;
    private int userID;
    private String address;
    private String email;
    private String tel;

    public Customer() {
    }

    public Customer(int customerID, int userID, String address, String email, String tel) {

        this.customerID = customerID;
        this.userID = userID;
        this.address = address;
        this.email = email;
        this.tel = tel;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "顾客信息{" +
                "customerID=" + customerID +
                ", userID=" + userID +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", tel='" + tel + '\'' +
                '}';
    }
}
