package com.charles.bank.entity;

/**账户类型表
 * Created by chaersi on 2017/7/17.
 */
public class AccountType {
    /**
     * accountTypeID：账户类型id
     * accountTypeName：账户类型名称【1：白玉兰借记卡 2：郁金香信用卡】
     */
    private int accountTypeID;
    private String accountTypeName;

    public AccountType() {
    }

    public AccountType(int accountTypeID, String accountTypeName) {

        this.accountTypeID = accountTypeID;
        this.accountTypeName = accountTypeName;
    }

    public int getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(int accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @Override
    public String toString() {
        return "账户类型信息{" +
                "accountTypeID=" + accountTypeID +
                ", accountTypeName='" + accountTypeName + '\'' +
                '}';
    }
}
