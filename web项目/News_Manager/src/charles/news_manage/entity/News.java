package charles.news_manage.entity;

import java.util.Date;

/**
 * Created by Charles Zheng on 2017/8/2.
 */
public class News {
    private int id;
    private int topic_id;
    private String title;
    private String content;
    private Date time;

    public News() {
    }

    public News(int id, int topic_id, String title, String content, Date time) {

        this.id = id;
        this.topic_id = topic_id;
        this.title = title;
        this.content = content;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTopic_id() {
        return topic_id;
    }

    public void setTopic_id(int topic_id) {
        this.topic_id = topic_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
