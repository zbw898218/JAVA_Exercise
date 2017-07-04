package Exercise.DVDSystem;

/**
 * 管理员类
 * 1.管理员账号不需要注册产生，禁止创建Admin实例，通过单例模式提供唯一对象
 * Created by Charles on 2017/6/15
 */
public class Admin implements User{
    private String name;
    private String pwd;
    private int level=User.ADMIN_LEVEL;
    public Admin(){}
    public Admin(String name,String pwd){
        this.name=name;
        this.pwd=pwd;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 管理员添加新dvd的方法
     * @param dvdInfo 要添加的dvd信息，包括名称和租金
     * @return 返回添加成功与否
     */
    public boolean addDVD(String[] dvdInfo){
        boolean addFlg=true;//标记增加dvd的状态，默认可以添加
        //遍历dvd列表，确定要添加的是新的dvd，而不是已经存在的
        for(int i=0;i<DataCenter.dvdList.length;i++){
            if(DataCenter.dvdList[i]!=null){
                if(DataCenter.dvdList[i].getName().equals(dvdInfo[0])){
                    System.out.println("抱歉，该dvd已经存在！");
                    addFlg=false;
                    break;
                }
            }
        }
        if(addFlg){
            for(int i=0;i<DataCenter.dvdList.length;i++){
                if(DataCenter.dvdList[i]==null) {
                    //新增dvd对象，并设置dvd编号和租金
                    DataCenter.dvdList[i]=new DVD(dvdInfo[0],Integer.parseInt(dvdInfo[1]));
                    DataCenter.dvdList[i].setId(i+1);//编号从1开始
                    break;
                }
            }
        }
        return addFlg;
    }

    /**
     * 管理员删除dvd，假设dvd被删除只是修改dvd的isdel属性，而非移除出dvd列表
     * @param dvdName 要删除的dvdName
     * @return 返回删除成功与否
     */
    public boolean delDVD(String dvdName){
        boolean isHave=false;//标记目标dvd是否存在，默认不存在
        boolean isDel=false;//标记删除状态。默认未删除
        //遍历dvd列表，确定要删除的dvd是存在的
        for(int i=0;i<DataCenter.dvdList.length;i++){
            if(DataCenter.dvdList[i]!=null){
                if(DataCenter.dvdList[i].getName().equals(dvdName)) {
                    isHave = true;
                    if (DataCenter.dvdList[i].getIsDel() == 0) {
                        DataCenter.dvdList[i].setIsDel(1);
                        isDel=true;
                        break;
                    } else {
                        System.out.println(dvdName + "已经被删除了！");
                        break;
                    }
                }
            }
        }
        if(!isHave){
            System.out.println(dvdName + "不存在！");
        }
        return isDel;
    }

//    /**
//     * 打印dvd列表信息
//     */
//    public void checkDVDList(){
//        PrintTool.printDVDList();
//    }


    @Override
    public String toString() {
        return "Admin{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", level=" + level +
                '}';
    }
}
