package charles.news_manage.entity;

/**
 * Created by Charles Zheng on 2017/8/2.
 */
public class NewsTopic {
    private int id;
    private String name;
    private int level=10;//默认显示等级

    public NewsTopic() {
    }

    public NewsTopic(int id, String name, int level) {

        this.id = id;
        this.name = name;
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
