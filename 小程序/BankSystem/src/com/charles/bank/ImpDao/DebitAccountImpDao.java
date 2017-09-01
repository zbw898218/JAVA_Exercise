package com.charles.bank.ImpDao;

import com.charles.bank.JDBC.GetConnection;
import com.charles.bank.Tools.GET_SQL;
import com.charles.bank.dao.DebitAccountDao;
import com.charles.bank.entity.Account;
import com.charles.bank.entity.DebitAccount;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaersi on 2017/7/18.
 */
public class DebitAccountImpDao implements DebitAccountDao {
    @Override
    public void addNewDebitAccount(DebitAccount debitAccount) {
        Connection con= GetConnection.getCon();
        PreparedStatement ps=null;
        Account account=null;
        try {
            ps=con.prepareStatement(GET_SQL.SQL_INSERT_DEBITACCOUNT);
            ps.setInt(1,debitAccount.getDebitAccountID());
            ps.setInt(2,debitAccount.getAccountID());
            ps.setDouble(3,debitAccount.getBalance());
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

    @Override
    public List<DebitAccount> selectAllDebitAccount() {
        List<DebitAccount> debitAccountList=new ArrayList<>();
        Connection con= GetConnection.getCon();
        PreparedStatement ps=null;
        ResultSet rs=null;
        DebitAccount debitAccount=null;
        try {
            ps=con.prepareStatement(GET_SQL.SQL_SELECT_ACCOUNT);
            rs=ps.executeQuery();
            while(rs.next()){
                debitAccount=new DebitAccount();
                debitAccount.setDebitAccountID(rs.getInt(1));
                debitAccount.setAccountID(rs.getInt(2));
                debitAccount.setBalance(rs.getDouble(3));
                debitAccountList.add(debitAccount);
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
            return debitAccountList;
        }

    }
}
