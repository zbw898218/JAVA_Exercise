package charles.news_manage.service;

import charles.news_manage.Factory.NewsTopicFactory;
import charles.news_manage.dao.INewsTopicDAO;
import charles.news_manage.entity.News;
import charles.news_manage.entity.NewsTopic;

import java.util.List;

/**
 * Created by chaersi on 2017/8/2.
 */
public class NewsTopicService {
    INewsTopicDAO newsTopicDAO=null;

    public NewsTopicService(){
        try {
            this.newsTopicDAO = NewsTopicFactory.getNewInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<NewsTopic> findAll(String keyWord){
        List<NewsTopic> newsTopics=null;
        try {
            newsTopics=newsTopicDAO.findAll(keyWord);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsTopics;
    }
    /**
     * 提供判断新闻主题是否为新的方法
     * @param name
     * @return
     */
    public boolean isNew(String name){
        boolean isNewName=true;
        try {
            int id=this.newsTopicDAO.findByName(name);
            if(id!=0){
                isNewName=false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isNewName;
    }

    public boolean doInsert(String topic_name){
        boolean isAdd=false;
        NewsTopic topic=new NewsTopic();
        topic.setName(topic_name);
        topic.setLevel(10);
        try {
            isAdd=newsTopicDAO.doInsert(topic);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isAdd;
    }

    public int findByName(String name){
        int id=0;
        try {
            id=this.newsTopicDAO.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }
    public boolean doUpdate(String oldName,String newName){
        boolean flag=false;
        try {
            List<NewsTopic> newsTopics=this.newsTopicDAO.findAll(oldName);
            NewsTopic topic=newsTopics.get(0);
            topic.setName(newName);
            flag=this.newsTopicDAO.doUpdate(topic);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean doDelete(String oldName){
        boolean isDel=false;
        int id=this.findByName(oldName);
        try {
            isDel=this.newsTopicDAO.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isDel;
    }
}
