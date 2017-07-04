package com.charles.entity;

/**
 * 顾客类
 * Created by Charles on 2017/6/27
 */
public class Customer extends User{
    private int custID;
    private static final int CUSTOMER_TYPE=1;
    public Customer() {
        super(CUSTOMER_TYPE);
    }
    public Customer(int custID) {
        super(CUSTOMER_TYPE);
        this.custID = custID;
    }
    public int getCustID() {
        return custID;
    }

    public void setCustID(int custID) {
        this.custID = custID;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custID=" + custID +
                "} " + super.toString();
    }
}
