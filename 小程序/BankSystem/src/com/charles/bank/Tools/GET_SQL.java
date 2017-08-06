package com.charles.bank.Tools;

/**
 * SQL语句类
 * Created by Administrator on 2017/7/18.
 */
public class GET_SQL {
    public static final String SQL_SELECT_BANKUSER="SELECT * FROM bankuser";
    public static final String SQL_SELECT_BANKCUSTOMER="SELECT * FROM BANKCUSTOMER";
    public static final String SQL_SELECT_BANKINFO="SELECT * FROM BANKINFO";
    public static final String SQL_SELECT_ACCOUNT="SELECT * FROM ACCOUNT";
    public static final String SQL_INSERT_BANKUSER="INSERT INTO BANKUSER VALUES(?,?,?,?,?,?,?,?)";
    public static final String SQL_INSERT_BANKCUSTOMER="INSERT INTO BANKCUSTOMER VALUES(?,?,?,?,?)";
    public static final String SQL_INSERT_DEBITACCOUNT="INSERT INTO DEBITACCOUNT VALUES(?,?,?)";
    public static final String SQL_INSERT_ACCOUNT="INSERT INTO ACCOUNT VALUES(?,?,?,?,?)";
    public static final String SQL_UPDATE_BANKUSER="UPDATE BANKUSER SET USERNAME=?,userPwd=?,userAge=? WHERE USERID=? ";
    public static final String SQL_UPDATE_BANKCUSTOMER="UPDATE BANKCUSTOMER SET address=?,EAMIL=?,TEL=? WHERE USERID=? ";
}
