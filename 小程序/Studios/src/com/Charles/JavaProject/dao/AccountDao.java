package com.Charles.JavaProject.dao;

import com.Charles.JavaProject.entity.Account;
import java.util.List;

/**
 * 账户类
 * 提供：注册、查询方法
 * 登陆：只需验证用户名与密码，通过查询方法遍历即可
 * Created by Charles on 2017/7/2.
 */
public interface AccountDao {
    /**
     * 查询所有账户信息
     * @return List<Account>账户信息集合
     */
    List<Account> selectAll();
    /**
     * 注册账户方法，成功：返回AccountID ,失败：返回0
     * 系统影院管理员账号自动生成，不开放注册
     * @return AccountID
     */
    int register(Account account);
    
    /**
     * 更新账户信息
     * @param account
     */
    void updateAccount(Account account);
}
