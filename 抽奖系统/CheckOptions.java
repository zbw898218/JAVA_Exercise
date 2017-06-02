/**
 * Created by Charles on 2017/6/2
 */
public class CheckOptions {
    static Shop shop=new Shop();
    static boolean flgs=true;//大循环标记位
    public static void getCheck3(){

        boolean login=shop.isAnswer();//获得登录状态
//        System.out.println(login);
        if(login){
            int card=PrintClass.getCard();//获得输入的卡号
            boolean bs=PrintClass.getLuckCard(card);//获得中奖的结果，true：中奖

            if(bs) {
                System.out.println("请领取您的奖励！");
            }else{
                flgs=false;//跳出外层循环
//                System.out.print("系统退出，谢谢使用！");

            }
            boolean bss=PrintClass.consuCheck1();//获得选择的结果
            if(!bss){
                flgs=false;//跳出外层循环
                System.out.print("系统退出，谢谢使用！");
            }
        }else{
            System.out.println("请先登录！");
            getCheck2();
        }

    }
    public static void getCheck2(){
        int count=0;
        boolean bo=true;
        while (bo){
            if(count>=3){
                System.out.println("错误输入达到上限！谢谢惠顾！");
                flgs=false;
                break;
            }

            String[] str=PrintClass.loginFun();//收集顾客登陆信息
            Consumer con=new Consumer(str[0],str[1]);
            Consumer cc=shop.loginF(con);
            if(cc==null){
                count++;
                System.out.println("账户或密码输入错误！");

            }else{
                System.out.println("欢迎您："+str[0]);
                boolean bs=PrintClass.consuCheck1();
                if(!bs){
                    flgs=false;//跳出外层循环
                    System.out.print("系统退出，谢谢使用！");
                    break;//跳出内层循环
                }else{
                    PrintClass.printIndex();
                    break;//跳出内层循环
                }
            }
        }
    }
    public static void getCheck1(){
        boolean bo=true;
        while (bo){
//            标记用户是否要继续
            bo=PrintClass.consuCheck1();
            if(bo){
                PrintClass.printIndex();
                //                  接受顾客注册信息，将信息添加到顾客池中，暂时缺少重复用户名验证方法
                boolean answer=shop.sumFun(PrintClass.submitFun());

                break;//跳出注册内循环
            }else{
                flgs=false;//跳出外层循环
                System.out.print("系统退出，谢谢使用！");
                break;//跳出内层循环
            }
        }
    }

}
