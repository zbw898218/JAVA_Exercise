package Exercise.DVDSystem;

/**
 * 数据中心
 * 1.存储用户
 * Created by Charles on 2017/6/15
 */
public class DataCenter {
    public static User[] us=new User[10];
    public static DVD[] dvdList=new DVD[10];
    static {
//        3种角色各实例化一个对象并存入用户管理数组
        us[0]=new Admin("admin1","123");
        us[1]=new VIP("张三","123",100);
        us[2]=new Commer("李四","123");
//        预先存入2个备用dvd
        dvdList[0]=new DVD(5,"英雄",1);
        dvdList[1]=new DVD(10,"长城",2);
    }
    public DataCenter(){}


}
