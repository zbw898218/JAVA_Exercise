package com.charles.bank.service;

import com.charles.bank.ImpDao.UserImpDao;
import com.charles.bank.dao.UserDao;
import com.charles.bank.entity.User;

import java.util.Iterator;
import java.util.List;

/**
 * 用户服务类
 * Created by Administrator on 2017/7/18.
 */
public class UserService {
    UserDao userDao=new UserImpDao();
    BankCustomerService bcs=new BankCustomerService();

    /**
     * 检查用户登录信息，返回用户对象
     * @param user
     * @return
     */
    public User checkLoginInfo(User user){
        User tmp=null;
        boolean flg=false;
        List<User> userList=userDao.selectAllUser();
        Iterator<User> iter=userList.iterator();
        while (iter.hasNext()){
            tmp=iter.next();

            if(tmp.getUserName().equals(user.getUserName())&&tmp.getUserPwd().equals(user.getUserPwd())){
                flg=true;
                break;
            }
        }
        if(flg){
            return tmp;
        }else{
            return null;
        }

    }

    /**
     * 注册新用户的方法：
     * 第一步：校验用户名是否重复 ,不可用返回null
     * 第二步：更新用户基本表信息
     * @param user 返回新的用户对象
     * @return
     */
    public User registerNewUser(User user){
        User tmp=null;
        List<User> userList=userDao.selectAllUser();
        //校验用户名是否可用，没重复即可用
        boolean isReg=true;//默认可以注册
        isReg=checkUserName(user.getUserName());
        if(isReg){
            int userid=0;
            if(userList==null){
                userid=1;
            }else{
                userid=userList.get(userList.size()-1).getUserID()+1;
            }
            user.setUserID(userid);
            user.setUserTypeID(3);//默认注册的是普通用户
            userDao.addNewUser(user);//更新用户基本表
            return user;
        }else{
            return null;
        }
    }

    /**
     * 校验用户名是否可以用，真可用，假不可用
     * @param userName
     * @return
     */
    public boolean checkUserName(String userName){
        boolean isRep=true; //校验用户名是否可用，默认没有重复且不为空
        User tmp=null;
        List<User> userList=userDao.selectAllUser();
        Iterator<User> iter=userList.iterator();
        while(iter.hasNext()){
            tmp=iter.next();
            if(userName==null||tmp.getUserName().equals(userName)){
                //当注册的用户名为空或已存在，修改用户名状态
                isRep=false;
                break;
            }
        }
        return isRep;
    }

    public void updateUserInfo(User user){
        userDao.updateUserInfo(user);
    }
}
