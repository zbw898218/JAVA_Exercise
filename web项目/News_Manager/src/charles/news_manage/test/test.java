package charles.news_manage.test;

import charles.news_manage.entity.User;
import charles.news_manage.Factory.NewsTopicFactory;
import charles.news_manage.Factory.UserFactory;
import charles.news_manage.dao.INewsTopicDAO;
import charles.news_manage.dao.IUserDAO;
import charles.news_manage.entity.NewsTopic;

/**
 * Created by Charles Zheng on 2017/8/2.
 */
public class test {
    public static void main(String[] args){
        User user1=new User();
        user1.setUsername("admin1");
        user1.setPassword("123");
        user1.setLevel(1);
        NewsTopic topic=new NewsTopic();



        topic.setName("国内");
        topic.setLevel(1);

        try {
            IUserDAO user= UserFactory.getNewInstance();
            INewsTopicDAO newsTopic= NewsTopicFactory.getNewInstance();
//            System.out.println(user.doInsert(user1));
//            newsTopic.doInsert(topic);
            System.out.println(user.findByUser(user1));
//            System.out.println( newsTopic.doInsert(topic));
//            System.out.print( newsTopic.findAll("").get(0).getId());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
