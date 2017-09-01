package com.Charles.JavaProject.impdao;

import com.Charles.JavaProject.dao.AccountDao;
import com.Charles.JavaProject.entity.Account;
import com.Charles.JavaProject.jdbc.MyConnection;
import com.Charles.JavaProject.tools.GetFile;
import com.Charles.JavaProject.tools.IOTools;
import com.Charles.JavaProject.tools.SQLTools;
import com.Charles.JavaProject.tools.Tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 账户实现类
 * Created by Charles on 2017/7/2.
 */
public class AccountImpDao implements AccountDao {
    MyConnection myConnection=new MyConnection();
    public List<Account> selectAlls() {
        List<Account> accountList=new ArrayList<>();
        Account account=null;
        BufferedReader br=null;
        File account_file=new File(GetFile.ACCOUNT_FILE);
        try {
            br=IOTools.getReader(account_file);
            while(br.ready()){
                String str=br.readLine();
                String[] accountInfo= Tools.cgString(str);
                if(!accountInfo.equals("")){
                    int accountID=Integer.parseInt(accountInfo[0].split("=")[1]);
                    String accountName=accountInfo[1].split("=")[1];
                    String accountPwd=accountInfo[2].split("=")[1];
                    int accountType=Integer.parseInt(accountInfo[3].split("=")[1]);
                    int accountBalance=Integer.parseInt(accountInfo[4].split("=")[1]);
                    account=new Account(accountID,accountName,accountPwd,accountType,accountBalance);
                    accountList.add(account);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return accountList;
    }
    
    public int registers(Account account) {
        List<Account> accountList=selectAlls();
        int accountID=0;
        if(accountList.size()==0){
            accountID=0;
        }else{
            accountID =accountList.get(accountList.size()-1).getAccountID()+1;
        }
        String accountName=account.getAccountName();
        String accountPwd=account.getAccountPwd();
        int accountType=2;
        int accountBalance=account.getAccountBalance();
        BufferedWriter bw=null;
        Account newAccount=new Account(accountID,accountName,accountPwd,accountType,accountBalance);
        File account_file=new File(GetFile.ACCOUNT_FILE);
        System.out.println(newAccount);
        bw= IOTools.getWriter(account_file,true);
        try {
            bw.write(newAccount.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return accountID;
    }
    /**
     * 查询账户表信息，返回账户集合
     * @return
     */
    public List<Account> selectAll(){
        List<Account> accountList=new ArrayList<>();
        Connection myCon=myConnection.getConnection();
        Statement stm=null;
        ResultSet rst=null;
        try {
            stm=myCon.createStatement();
            rst=stm.executeQuery(SQLTools.SELECT_ACCOUNT);
            Account account=null;
            while(rst.next()){
                int accountID=rst.getInt(1);
                String accountName=rst.getString(2);
                String accountPwd=rst.getString(3);
                int accountType=rst.getInt(4);
                int accountBalance=rst.getInt(5);
                account=new Account(accountID,accountName,accountPwd,accountType,accountBalance);
                accountList.add(account);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                rst.close();
                stm.close();
                myCon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return accountList;
    }
    
    public int register(Account account){
        List<Account> accountList=selectAll();
        int accountID=0;
        if(accountList.size()==0){
            accountID=1;
        }else{
            accountID =accountList.get(accountList.size()-1).getAccountID()+1;
        }
        String accountName=account.getAccountName();
        String accountPwd=account.getAccountPwd();
        int accountType=2;
        int accountBalance=account.getAccountBalance();
        Connection myCon=myConnection.getConnection();
        PreparedStatement pst=null;
        try {
            pst=myCon.prepareStatement(SQLTools.INSERT_ACCOUNT);
            pst.setInt(1,accountID);
            pst.setString(2,accountName);
            pst.setString(3,accountPwd);
            pst.setInt(4,accountType);
            pst.setInt(5,accountBalance);
            pst.addBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pst.executeBatch();
                myCon.commit();
                myCon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return accountID;
    }
    
    @Override
    public void updateAccount(Account account) {
        Connection myCon=myConnection.getConnection();
        Statement stm=null;
        String sql="update account set AccountBalance="+account.getAccountBalance()+" where accountID="+account.getAccountID();
        try {
            stm=myCon.createStatement();
            stm.executeUpdate(sql);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                myCon.commit();
                myCon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    
    }
}
