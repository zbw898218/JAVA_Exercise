package com.charles.service;

import com.charles.dao.MasterDao;
import com.charles.entity.Master;

import java.util.Iterator;
import java.util.List;

/**
 * 主人类：
 * 提供注册信息录入和登录信息校验
 * Created by Charles on 2017/6/28
 */
public class MasterService {
    /**
     * 校验用户名是否可用
     * 是：追加写入Master.txt中，并返回masterID
     * 否：返回0或-1
     * @param regInfo
     * @return
     */
    public static int regMaster(String[] regInfo){
        int masterID=0;
        boolean reg=true;
        List<Master> masterList= MasterDao.selectAll();
        Iterator<Master> it=masterList.iterator();
        while(it.hasNext()){
            Master master=it.next();
            if(master.getMastName().equals(regInfo[1])){
                //校验用户名是否可用
                reg=false;
                break;
            }
        }
        if(reg){
            if(masterList.size()!=0){
                masterID=masterList.get(masterList.size()-1).getMasterID()+1;
            }else{
                masterID=1;
            }
            String mastName=regInfo[1];
            String mastPwd=regInfo[2];
            int mastAge=Integer.parseInt(regInfo[3]);
            int masterType=0;
            if(regInfo[0].equals("商家")){
                masterType=1;
            }else{
                masterType=2;
            }
            int mastMoney=Integer.parseInt(regInfo[4]);
            String newMasterInfo=masterID+","+mastName+","+mastPwd+","+mastAge+","+masterType+","+mastMoney;
            MasterDao.addNewMaser(newMasterInfo);
        }else{
            masterID=-1;
        }
        return masterID;
    }
    /**
     * 校验登录信息。返回主人id
     * @param loginInfo
     * @return
     */
    public static int checkLoginInfo(String[] loginInfo){
        int masterID=0;
        List<Master> masterList= MasterDao.selectAll();
        Iterator<Master> it=masterList.iterator();
        while(it.hasNext()){
            Master master=it.next();
            if(master.getMastName().equals(loginInfo[0])&&master.getMastPwd().equals(loginInfo[1])){
                //校验用户名和密码，找到后，返回主人id
                masterID=master.getMasterID();
                break;
            }
        }
        return masterID;
    }
    
    public static int getMasterType(int masterID){
        int masterType=0;
        List<Master> masterList= MasterDao.selectAll();
        Iterator<Master> it=masterList.iterator();
        while(it.hasNext()){
            Master master=it.next();
            if(master.getMasterID()==masterID){
                masterType=master.getMasterType();
                break;
            }
        }
        return masterType;
    }
    public static void updateMasterInfo(int oldMasterID,int newMasterID,int price){
        List<Master> masterList= MasterDao.selectAll();
        Iterator<Master> it=masterList.iterator();
        while(it.hasNext()){
            Master master=it.next();
            if(master.getMasterID()==oldMasterID){
                master.setMastMoney(master.getMastMoney()+price);
            }else if(master.getMasterID()==newMasterID){
                master.setMastMoney(master.getMastMoney()-price);
            }
        }
        MasterDao.updateMasterInfo(masterList);
    }

    public static int checkMasterType(int masterID) {
        int masterTypeID = 0;
        List<Master> masterList = MasterDao.selectAll();
        Iterator<Master> it = masterList.iterator();
        while (it.hasNext()) {
            Master master = it.next();
            if (master.getMasterID() == masterID) {
                masterTypeID = master.getMasterType();
            }

        }
        return masterTypeID;
    }
}
