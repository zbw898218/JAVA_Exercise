package Exercise.DVDSystem;

/**
 * dvd系统使用角色的父类
 * Created by Charles on 2017/6/15
 */
public interface User {
//    level:1.vip;2.commer;3.admin

    int ADMIN_LEVEL=3;
    int COMMER_LEVEL=2;
    int VIP_LEVEL=1;

    /**
     * 不论用户以管理员或顾客身份登录，均只需要接收用户名和密码，遍历数组获取找到的用户对象并返回
     * 故此：将方法以静态形式写在接口中，以User接收找到的登录对象并返回，继承此接口的所有用户即均获得了登录方法
     * 在使用中，通过instanceof关键字判断接收到的登录对象具体是什么类型，并做相应强制转换即可
     * @return
     */
    static User login() {
        User user = null;
        boolean login = false;//标记登录状态默认为false
        String[] loginInfo = PrintTool.getLoginInfo();//接收用户控制台输入的用户名和密码信息组成的数组
        for (int i = 0; i < DataCenter.us.length; i++) {

            if (DataCenter.us[i] != null) {
                if(DataCenter.us[i] instanceof Admin){
                    Admin admin=(Admin)DataCenter.us[i];
                    if (admin.getName().equals(loginInfo[0]) && admin.getPwd().equals(loginInfo[1])) {
                        login = true;  //遍历数组，找到用户名和密码相同的用户，即视为登录成功，将登录状态设置为true
                        user=admin;
                    }
                }else if(DataCenter.us[i] instanceof Customer){
                    Customer customer=(Customer)DataCenter.us[i];
                    if(customer.getName().equals(loginInfo[0]) && customer.getPwd().equals(loginInfo[1])){
                        login = true;
                        user=customer;
                    }
                }
            }
        }
        return user;
    }
}
