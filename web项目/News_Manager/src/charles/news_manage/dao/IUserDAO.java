package charles.news_manage.dao;

import charles.news_manage.entity.User;

/**
 * Created by Charles Zheng on 2017/8/2.
 */
public interface IUserDAO {
    /**
     * 登录查询，输入用户名和密码；
     * 封装成user对象，查询数据库返回布尔值
     * @param user
     * @return
     */
   boolean findByUser(User user) throws Exception;

    /**
     * 新增用户操作：
     * 返回新增结果
     * @param user
     * @return
     * @throws Exception
     */
   boolean doInsert(User user) throws Exception;

    /**
     * 更新用户信息
     * @param user
     * @return
     * @throws Exception
     */
   boolean doUpdate(User user)throws Exception;
}
