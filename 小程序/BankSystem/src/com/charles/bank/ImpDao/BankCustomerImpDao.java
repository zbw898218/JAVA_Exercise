package com.charles.bank.ImpDao;

import com.charles.bank.JDBC.GetConnection;
import com.charles.bank.Tools.GET_SQL;
import com.charles.bank.dao.BankCustomerDao;
import com.charles.bank.entity.BankCustomer;
import com.charles.bank.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/18.
 */
public class BankCustomerImpDao implements BankCustomerDao {
    @Override
    public List<BankCustomer> selectAllCustomer() {
        List<BankCustomer> bcList=new ArrayList<>();
        Connection con= GetConnection.getCon();
        BankCustomer bc=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con.setAutoCommit(false);
            ps=con.prepareStatement(GET_SQL.SQL_SELECT_BANKCUSTOMER);
            rs=ps.executeQuery();
            while(rs.next()){
                bc=new BankCustomer();
                bc.setCustomerID(rs.getInt(1));
                bc.setUserID(rs.getInt(2));
                bc.setAddress(rs.getString(3));
                bc.setEmail(rs.getString(4));
                bc.setTel(rs.getString(5));
                bcList.add(bc);
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
            return bcList;
        }

    }

    @Override
    public void addNewCustomer(BankCustomer bc) {
        Connection con= GetConnection.getCon();
        PreparedStatement ps=null;
        try {
            ps=con.prepareStatement(GET_SQL.SQL_INSERT_BANKCUSTOMER);
            ps.setInt(1,bc.getCustomerID());
            ps.setInt(2,bc.getUserID());
            ps.setString(3,bc.getAddress());
            ps.setString(4,bc.getEmail());
            ps.setString(5,bc.getTel());
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
    public void updateCustomerInfo(BankCustomer bc) {
        Connection con= GetConnection.getCon();
        PreparedStatement ps=null;
        try {
            ps=con.prepareStatement(GET_SQL.SQL_UPDATE_BANKCUSTOMER);
            ps.setString(1,bc.getAddress());
            ps.setString(2,bc.getEmail());
            ps.setString(3,bc.getTel());
            ps.setInt(4,bc.getUserID());
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
