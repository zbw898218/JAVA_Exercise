package charles.news_manage.dao;

import charles.news_manage.entity.NewsTopic;

import java.util.List;

/**
 * Created by Charles Zheng on 2017/8/2.
 */
public interface INewsTopicDAO {
    /**
     * 根据关键字查询所有主题信息
     * @param keywords
     * @return
     */
    List<NewsTopic> findAll(String keywords) throws Exception;

    /**
     * 输入主题名称，查看是否存在,存在返回主题id
     * @param name
     * @return
     */
    int findByName(String name) throws Exception;

    /**
     * 根据主题id删除主题
     * @param id
     * @return
     */
    boolean deleteById(int id) throws Exception;

    /**
     * 添加主题
     * @param newsTopic
     * @return
     */
    boolean doInsert(NewsTopic newsTopic) throws Exception;

    /**
     * 修改主题
     * @param newsTopic
     * @return
     */
    boolean doUpdate(NewsTopic newsTopic) throws Exception;
}
