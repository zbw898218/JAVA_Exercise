package com.charles.bank.ImpDao;

import com.charles.bank.JDBC.GetConnection;
import com.charles.bank.Tools.GET_SQL;
import com.charles.bank.dao.AccountDao;
import com.charles.bank.entity.Account;
import com.charles.bank.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 银行账户实现类
 * Created by chaersi on 2017/7/18.
 */
public class AccountImpDao implements AccountDao {
    @Override
    public List<Account> selectAllAccount() {
        List<Account> accountList=new ArrayList<>();
        Connection con= GetConnection.getCon();
        PreparedStatement ps=null;
        ResultSet rs=null;
        Account account=null;
        try {
            ps=con.prepareStatement(GET_SQL.SQL_SELECT_ACCOUNT);
            rs=ps.executeQuery();
            while(rs.next()){
                account=new Account();
                account.setAccountID(rs.getInt(1));
                account.setUserID(rs.getInt(2));
                account.setBankID(rs.getInt(3));
                account.setAccountstatus(rs.getInt(4));
                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(rs!=null){
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            return accountList;
        }

    }

    @Override
    public void addNewAccount(Account tmp) {
        Connection con= GetConnection.getCon();
        PreparedStatement ps=null;
        Account account=null;
        try {
            ps=con.prepareStatement(GET_SQL.SQL_INSERT_ACCOUNT);
            ps.setInt(1,tmp.getAccountID());
            ps.setInt(2,tmp.getUserID());
            ps.setInt(3,tmp.getBankID());
            ps.setInt(4,tmp.getAccountTypeID());
            ps.setInt(5,tmp.getAccountstatus());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(ps!=null){
                try {
                    ps.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(con!=null){
                try {
                    con.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
