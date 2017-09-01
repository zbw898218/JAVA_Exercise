package com.charles.bank.ImpDao;

import com.charles.bank.JDBC.GetConnection;
import com.charles.bank.Tools.GET_SQL;
import com.charles.bank.dao.BankInfoDao;
import com.charles.bank.entity.BankInfo;
import com.charles.bank.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by chaersi on 2017/7/18.
 */
public class BankInfoImpDao implements BankInfoDao {
    @Override
    public List<BankInfo> selectAllBanks() {
        List<BankInfo> bankInfos=new ArrayList<>();
        Connection con= GetConnection.getCon();
        PreparedStatement ps=null;
        ResultSet rs=null;
        BankInfo bankInfo =null;
        try {
            ps=con.prepareStatement(GET_SQL.SQL_SELECT_BANKINFO);
            rs=ps.executeQuery();
            while(rs.next()){
                bankInfo=new BankInfo();
                bankInfo.setBankID(rs.getInt(1));
                bankInfo.setBankName(rs.getString(2));
                bankInfos.add(bankInfo);
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
            return bankInfos;
        }
    }
}
