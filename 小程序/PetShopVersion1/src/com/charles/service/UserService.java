package com.charles.service;

import com.charles.dao.UserDao;
import com.charles.entity.Shop;
import com.charles.entity.User;
import com.charles.tools.Tools;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 用户逻辑类
 * Created by Charles on 2017/6/27
 */
public class UserService {
    /**
     * 注册
     */
    static UserDao ud=new UserDao() ;
    public static boolean register(int regType,String[] regInfo){
        boolean reg=true;//默认可注册状态
        List<User> userList=ud.selectAllUsers();
        Iterator<User> it= userList.iterator();
        while(it.hasNext()){
            User us=it.next();
            if(us.getUserName().equals(regInfo[0])){
                reg=false;//用户名存在，修改注册状态跳出循环
                break;
            }
        }
        if(reg){
            User newUser=new User(regType);
            newUser.setUserName(regInfo[0]);
            newUser.setUserPwd(regInfo[1]);
            newUser.setMoney(Integer.parseInt(regInfo[2]));
            newUser.setAddress(regInfo[3]);
            ud.add(newUser);
            reg=true;
        }
        return reg;
    }

    /**
     * 登录
     * @return
     */
    public static boolean login(String[] loginInfo){
        boolean login=false;
        List<User> userList=ud.selectAllUsers();
        Iterator<User> it= userList.iterator();
        while(it.hasNext()){
            User us=it.next();
            if(us.getUserName().equals(loginInfo[0])&&us.getUserPwd().equals(loginInfo[1])){
                login=true;//用户名存在，修改注册状态跳出循环
                break;
            }
        }
        return login;
    }
    
    /**
     * 查询商户信息，并以list集合形式返回
     * @return
     */
    public static List<User> selectShops(){
        List<User> userList=ud.selectAllUsers();
        List<User> shops=new ArrayList<>();
        Iterator<User> it=userList.iterator();
        while(it.hasNext()){
            User user=it.next();
            if(user.getUserType()==0){
                shops.add(user);
            }
        }
        return shops;
    }
}
