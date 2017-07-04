package com.charles.dao;

import com.charles.entity.Master;
import com.charles.entity.Pet;
import com.charles.tools.GetFile;
import com.charles.tools.IOTools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * Created by Charles on 2017/6/28
 */
public class MasterDao {
    /**
     * 获得所有主人数据
     * @return
     */
    public static List<Master> selectAll() {
        List<Master> masterList = new ArrayList<>();
        BufferedReader br = null;
        Master master=null;
        File file = new File(GetFile.MASTER_FILE_NAME);
        br = IOTools.reader(file);
        try {
            while (br.ready()) {
                String str = br.readLine();
                if (!str.equals("")) {
                    String[] masterInfo = str.split(",");
                    int masterID=Integer.parseInt(masterInfo[0]);
                    String mastName=masterInfo[1];
                    String mastPwd=masterInfo[2];
                    int mastAge=Integer.parseInt(masterInfo[3]);
                    int masterType=Integer.parseInt(masterInfo[4]);
                    int mastMoney=Integer.parseInt(masterInfo[5]);
                    master=new Master(masterID,mastName,mastPwd,mastAge,masterType,mastMoney);
                    masterList.add(master);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return masterList;
    }

    /**
     * 追加写入新注册的用户信息
     * @param newMasterInfo
     */
    public static void addNewMaser(String newMasterInfo){
        BufferedWriter bw=null;
        File file = new File(GetFile.MASTER_FILE_NAME);
        bw=IOTools.writer(file);
        try {
            bw.write(newMasterInfo);
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
    }
    
    public static void updateMasterInfo(List<Master> masterList){
        BufferedWriter bw=null;
        File file=new File(GetFile.MASTER_FILE_NAME);
        bw=IOTools.writers(file);
        Master master=null;
        Iterator<Master> it=masterList.iterator();
        while(it.hasNext()){
            master=it.next();
            String masterInfo=master.getMasterID()+","+master.getMastName()+","+master.getMastPwd()+","+master.getMastAge()+","+master.getMasterType()+","+master.getMastMoney();
            try {
                bw.write(masterInfo);
                bw.newLine();
            } catch (IOException e) {
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
