package Exercise.DVDSystem;

/**
 * 管理系统
 * Created by Charles on 2017/6/15
 */
public class ManagerSystem {
    private int count=0;//计数器
    int check1=0;//选择登录或者注册
    int check2=0;//选择注册用户的种类：vip或普通
    int check3=0;//管理界面选择的操作项
    int check4=0;//选项间切换
    User user;//用户操作对象
//    Customer customer;//操作的用户对象
//    Admin admin;//操作的管理员对象
    boolean flg=true,login=false;

    /**
     * start():该方法主要获得用户登录状态
     * 1.注册成功，登录状态改成true
     * 2.登录成功，登录状态改成true
     * 3.退出，登录状态改成false，打印谢谢信息！
     */
    public void start(){

        while(true){
           check1=PrintTool.index();
           switch (check1){
               /**
                * case 1：代表选择注册，
                */
               case 1:
                // 控制台接收选择注册的用户类别
                   check2=PrintTool.registerCheck();
                // 注册用户并接收生成的注册对象
                   user=Customer.register(check2);
                   if(user!=null){
                       System.out.println("注册成功！");
                       login=true;
                       count=3;
                   }else{
                       System.out.println("注册失败！");
                       count++;
                   }
                   break;
               /**
                * case 2：代表选择登录，
                *
                */
               case 2:
                   user=User.login();
                   System.out.println(user);
                   if(user!=null) {//user不为空，即代表登录成功，接收到登录的用户对象了
                       System.out.println("登录成功！");
                       login = true;
                       count=3;
                   }else{
                       System.out.println("登录失败！");
                       count++;
                   }
                   break;
               /**
                * case 3：代表选择退出，
                */
               case 3:
                   System.out.println("谢谢惠顾！");
                   count=3;
                   break;
               default:
                   System.out.println("输入错误，请重新输入！");
                   count++;
                   break;
           }
           if(count==3){
                break;
           }
        }
        if(login){
            loginManager(user);
        }
    }

    /**
     *获取登录角色，
     * 判断登录角色身份，进入对应管理界面
     */
    public void loginManager(User user){
        //判断用户登录状态
            if(user!=null){//进入用户操作界面
                /**
                 * 通过instanceof判断登录的用户角色
                 * 通过强制转换，获得对应角色的登录对象，进入对应操作界面
                 */
                if(user instanceof Customer){
                    Customer customer=(Customer) user;//获取顾客对象，
                    customerOperationGUI(customer);//进入顾客界面
                }else{
                    Admin admin=(Admin)user;//获取管理员对象
                    adminOperationGUI(admin);//进入管理员界面
                }
            }
    }
    /**
     * 管理员用户操作界面
     */
    public void adminOperationGUI(Admin admin){
        System.out.println("*********欢迎进入Charles\'s 的音像店*********");
        boolean con=true;
        while(con){
            check4=PrintTool.adminGUI();
            switch (check4){
                case 1://新增dvd
                    String[] info=PrintTool.getAddDVDInfo();
                    boolean add=admin.addDVD(info);
                    if(add){
                        System.out.println("添加成功！");

                    }
                    PrintTool.printAdminDVDList();
                    break;
                case 2://删除dvd
                    String dvdName=PrintTool.getDelDVDName();
                    boolean del=admin.delDVD(dvdName);
                    if(del){
                        System.out.println("删除成功！");
                    }
                    PrintTool.printAdminDVDList();
                    break;
                case 3://查看dvd
                    PrintTool.printAdminDVDList();
                    break;
                case 4:
                    System.out.println("谢谢惠顾！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("输入错误！");
                    break;
            }
            int isCon=PrintTool.getStatus();
            if(isCon==1){

        }else if(isCon==2){
                System.out.println("谢谢，再见！");
                System.exit(0);
                con=false;
            }else{
                System.out.println("选择错误！");
            }

            }

    }
    /**
     * 顾客操作界面
     */
    public void customerOperationGUI(Customer customer){
        System.out.println("*********欢迎进入Charles\'s 的音像店*********");
        while(true){
            check4=PrintTool.customerGUI();
            switch (check4){
                case 1://租借dvd
                    break;
                case 2://归还dvd
                    break;
                case 3://查看dvd列表
                    PrintTool.printCustomerDVDList();
                    break;
                case 4:
                    System.out.println("谢谢，再见！");
                    System.exit(0);
                    break;
                default:
                    System.out.println("选择错误！");
                    break;
            }
        }
    }

    public static void main(String[] args){
        ManagerSystem managerSystem=new ManagerSystem();
        managerSystem.start();
    }
}


