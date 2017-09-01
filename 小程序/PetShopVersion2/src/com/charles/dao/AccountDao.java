package com.charles.dao;

import com.charles.entity.Account;
import com.charles.tools.GetFile;
import com.charles.tools.IOTools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.io.File;

/**
 *
 * Created by Charles on 2017/6/28
 */
public class AccountDao {
    public static List<Account> selectAccounts() {
        List<Account> accountList = new ArrayList<>();
        BufferedReader br = null;
        Account account = null;
        File file = new File(GetFile.ACCOUNT_FILE_NAME);
        br = IOTools.reader(file);
        try {
            while (br.ready()) {
                String str = br.readLine();
                if (!str.equals("")) {
                    String[] accInfo = str.split(",");
                    account = new Account();
                    account.setAccountID(Integer.parseInt(accInfo[0]));
                    account.setAccountName(accInfo[1]);
                    account.setAccountPwd(accInfo[2]);
                    account.setAccountBalance(Integer.parseInt(accInfo[3]));
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

    /**
     * 更新账户表信息
     * @param accountList
     */
    public static void updateAccount(List<Account> accountList){
        BufferedWriter bw=null;
        File file=new File(GetFile.ACCOUNT_FILE_NAME);
        bw=IOTools.writers(file);
        Iterator<Account> it=accountList.iterator();
        while(it.hasNext()){
            Account temp=it.next();
             int accountID=temp.getAccountID();
             String accountName=temp.getAccountName();
             String accountPwd=temp.getAccountPwd();
             int accountBalance=temp.getAccountBalance();
             String accInfo=accountID+","+accountName+","+accountPwd+","+accountBalance;
            try {
                bw.write(accInfo);
                bw.newLine();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
