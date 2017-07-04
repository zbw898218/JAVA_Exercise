package com.charles.dao;

import com.charles.entity.Pet;
import com.charles.entity.User;
import com.charles.tools.Tools;

import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Charles on 2017/6/27
 */
public  class UserDao implements DAO<User,Pet> {
    /**
     * 增加用户的方法，即注册
     * @param t
     */
    @Override
    public void add(User t) {
        BufferedWriter bw=null;
        List<User> userList=selectAllUsers();
        try {
            bw=Tools.writer(Tools.USER_FILE);
            int ID=0;
             if(userList.size()==0){
                 ID=1;
             }else {
                 ID=userList.get(userList.size()-1).getID()+1;//找到最后一个元素，id+1
             }
             int userType=t.getUserType();
             String userName=t.getUserName();
             String userPwd=t.getUserPwd();
             int money=t.getMoney();
             String address=t.getAddress();
             int isDel=t.getIsDel();
             String userInfo=ID+","+userType+","+userName+","+userPwd+","+money+","+address+","+isDel;
             bw.write(userInfo);
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

    /**
     * 删除用户的方法
     * @param t
     */
    @Override
    public void del(User t) {

    }

    @Override
    public void alter(User t) {

    }

    /**
     * 查询单个用户是否存在
     * 存在：返回true
     * 不存在：返回fals
     * @param t
     * @return
     */
//    public boolean selectUser(User t) {
//        boolean isHave=false;
//        List<User> userList=selectAllUsers();
//        Iterator<User> it=userList.iterator()
//
//        return isHave;
//    }


    /**
     * 查询所有用户的方法，以集合的形式返回
     * @param
     * @return
     */
    public List<User> selectAllUsers() {
        List<User> userLists=new ArrayList<>();
        BufferedReader br= null;

        try {
            br = Tools.reader(Tools.USER_FILE);
            String str="";
            while((str=br.readLine())!=null){
                if(!str.equals("")){
                    String[] userInfo=str.trim().split(",");//返回查询到的用户属性组成的数组
                    User users=new User();
                    users.setID(Integer.parseInt(userInfo[0]));
                    users.setUserType(Integer.parseInt(userInfo[1]));
                    users.setUserName(userInfo[2]);
                    users.setUserPwd(userInfo[3]);
                    users.setMoney(Integer.parseInt(userInfo[4]));
                    users.setAddress(userInfo[5]);
                    users.setIsDel(Integer.parseInt(userInfo[6]));
                    userLists.add(users);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return userLists;
    }

}
