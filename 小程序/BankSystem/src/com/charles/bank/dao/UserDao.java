package com.charles.bank.dao;

import com.charles.bank.entity.User;

import java.util.List;

/**
 * 用户Dao接口
 * Created by Administrator on 2017/7/18.
 */
public interface UserDao {
     /**
      * 查询所有用户信息，以用户集合形式返回
      * @return
      */
     List<User> selectAllUser();

     /**
      * 注册新的用户
      * @param user
      */
     void addNewUser(User user);

     /**
      * 更新用户信息
      * @param user
      */
     void updateUserInfo(User user);
}
