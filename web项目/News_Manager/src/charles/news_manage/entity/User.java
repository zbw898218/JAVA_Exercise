package charles.news_manage.entity;

/**
 * Created by Charles Zheng on 2017/8/2.
 */
public class User {
    private int id;
    private String username;
    private String password;
    private int level =2 ;//默认普通用户，level=2 管理员：1

    public User() {
    }

    public User(int id, String username, String password, int level) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.level = level;
    }

    public User(int id, String username, String password) {

        this.id = id;
        this.username = username;
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
