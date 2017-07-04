package Exercise.DVDSystem;

/**
 * 顾客角色的父类
 * Created by Charles on 2017/6/15
 */
public abstract class Customer implements User {
    private String name;
    private String pwd;
    private int level;
    private double balance;
    private double discount;
    private static Customer customer;
    public Customer() {
    }

    /**
     * 普通注册构造方法
     * @param name
     * @param pwd
     */
    public Customer(String name, String pwd) {
        this.name = name;
        this.pwd = pwd;
    }

    /**
     * VIP注册构造方法
     * @param name
     * @param pwd
     * @param balance
     */
    public Customer(String name, String pwd, double balance) {
        this.name = name;
        this.pwd = pwd;
        this.balance = balance;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    /**
     * 实现用户选择并注册指定类型账号：vip/com
     * @param check ：用户选择注册的用户类型
     * @return 返回注册生成的用户对象；
     */
    public static Customer register(int check){
        boolean flg=true;
        String[] registerInfo=null;//接收用户注册信息的数组
        if(check==1) {//注册普通用户
            registerInfo=PrintTool.getInfo();
        }else if(check==2) {//注册VIP用户
            registerInfo=PrintTool.getVipInfo();
        }else if(check==3) {//返回登录页面
            flg=false;
        }else{//输入错误！
            flg=false;
        }
        /**
         * 检查用户名是否可用
         * 遍历用户列表获取用户名，如果相等，说明用户名已被注册，可注册flg标记设置为false
         */
        if(registerInfo!=null) {
            for(int i=0;i<DataCenter.us.length;i++){
                if(DataCenter.us[i]!=null) {
                    Customer customer = (Customer) DataCenter.us[i];
//                        找到相同用户名，将注册状态改成不可注册
                    if (customer.getName().equals(registerInfo[0])) {
                        flg = false;
                    }
                }
            }
            /**
             *   注册状态为可注册时，进行注册步骤，生成对象并加入到DataCenter类的用户管理数组中
             *   普通用户注册，只需要接收用户名和密码，数组长度2；
             *   VIP用户注册，需要接收用户名、密码和充值金额，数组长度3；
             *   通过判断数组长度确定用户注册的类别
             */
            if(flg&&registerInfo.length==2){
                customer=new Commer(registerInfo[0],registerInfo[1]);
            }else if(flg&&registerInfo.length==3){
                customer=new VIP(registerInfo[0],registerInfo[1],Double.parseDouble(registerInfo[2]));
            }else {
                System.out.println("注册失败！");
            }
        }
        /**
         * 用户创建成功后需要将注册生成的对象加入到用户管理数组当中
         * @param customer
         */
        if(customer!=null){
            for(int i=0;i<DataCenter.us.length;i++){
                if(DataCenter.us[i]==null){
                    DataCenter.us[i]=customer;
                    break;
                }
            }
        }
        return customer;
    }

    /**
     * 假设租借的时候不计算押金，普通用户和vip用户租借的方法一致，顾直接在抽象顾客父类中实现租借方法
     * @param dvdName 要租借的dvd名称
     * @return 返回租借是否成功
     */
    public  boolean loanDvd(String dvdName){
        boolean loanFlg=false;//标记租借状态，默认失败
        boolean isHave=false;//标记dvd列表中是否有要租借的dvd对象，默认为false
        for(int i=0;i<DataCenter.dvdList.length;i++){
            if(DataCenter.dvdList[i]!=null){
                if(DataCenter.dvdList[i].getName().equals(dvdName)) {//找到该dvd
                    isHave = true;
                    if (DataCenter.dvdList[i].getRent() == 0) {//租借状态为0，说明可以租借
                        loanFlg = true;//修改用户租借状态
                        DataCenter.dvdList[i].setRent(1);//修改dvd对象租借状态
                        break;
                    } else {
                        System.out.println("抱歉，您要的dvd已被借了！");
                        break;
                    }
                }
            }
        }
        if(!isHave){
            System.out.println("抱歉，没有您要租借的dvd！");
        }
        return loanFlg;
    }

    /**
     * 假设归还dvd的时候，普通用户和vip用户实现方法有差异，存在折扣问题，顾定义成抽象方法。在子类中分别实现
     * @param dvdName 要归还的dvd名称
     * @return 返回归还是否成功
     */
    public abstract boolean returnDvd(String dvdName);

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", level=" + level +
                ", balance=" + balance +
                ", discount=" + discount +
                '}';
    }
}
