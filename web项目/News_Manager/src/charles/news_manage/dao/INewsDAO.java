package charles.news_manage.dao;

import charles.news_manage.entity.News;

import java.util.List;

/**
 * Created by Charles Zheng on 2017/8/2.
 */
public interface INewsDAO {
    List<News> findAllNews(String keyword) throws Exception;
    List<News> findAllNews(int topic_id) throws Exception;
}
