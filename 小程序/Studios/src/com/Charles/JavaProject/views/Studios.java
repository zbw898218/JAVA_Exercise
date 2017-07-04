package com.Charles.JavaProject.views;

import com.Charles.JavaProject.entity.Seats;
import com.Charles.JavaProject.service.*;
import com.Charles.JavaProject.tools.CheckTools;
import com.Charles.JavaProject.tools.IOTools;
import com.Charles.JavaProject.tools.PrintTools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * 电影商城类：
 * 程序主入口
 * Created by Charles on 2017/7/1.
 */
public class Studios {
    AccountService accountService=new AccountService();
    CinemaService cinemaService=new CinemaService();
    FilmService filmService=new FilmService();
    ScheduleService scheduleService=new ScheduleService();
    SeatsService seatsService=new SeatsService();
    private int accountID;//登陆的账户id
    public int getAccountID() {
        return accountID;
    }
    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }
    /**
     * 程序入口
     */
    public void start() {
        PrintTools.printIndex();
        int check=PrintTools.firstCheck();
        switch (check){
            case 1://注册
                String[] regInfo=null;//注册的用户信息数组
                int regCon=0;//注册次数限制
                while(accountID==0){
                    if(regCon>=3){
                        System.out.println("错误已达上限，谢谢再见！");
                        break;
                    }
                    regInfo=PrintTools.getRegInfo();
                    regCon++;
                    if(regInfo!=null){
                        accountID=accountService.register(regInfo);
                        if(accountID==0){
                            System.out.println("账号已被注册，请更换账号！");
                        }else{
                            System.out.println("恭喜，注册成功！");
                            break;
                        }
                    }
                }
                break;
            case 2://登陆
                String[] loginInfo=null;//登陆的用户信息数组
                int loginCon=0;//登陆次数限制
                while(accountID==0){
                    if(loginCon>=3){
                        System.out.println("错误已达上限，谢谢再见！");
                        break;
                    }
                    loginInfo=PrintTools.getLoginInfo();
                    loginCon++;
                    accountID=accountService.login(loginInfo);
                    if(accountID==0){
                        System.out.println("账号或密码输入错误！");
                    }else{
                        System.out.println("恭喜，登陆成功！");
                        break;
                    }
                }
                break;
            case 3://退出
                System.out.println("谢谢，再见！");
                break;
            default://其他
                System.out.println("输入错误！");
                break;
        }
    }
    
    /**
     * 登陆后管理页面
     * @param accountID ：账户id
     */
    public void manager(int accountID){
        PrintTools.managerUI();
        int check=PrintTools.secondCheck();
        switch (check){
            case 1://查询电影院
                cinemaService.selectCinemas();
                break;
            case 2://查询上映电影
                scheduleService.selectAllFilmsInfo();
                break;
            case 3://查询指定电影
                String filmName=PrintTools.selectFilmName();
                scheduleService.selectOneFilmInfo(filmName);
                break;
            case 4://购买电影票
                String[] buyInfo=PrintTools.getBuyTicketInfo();//获得购买信息
                int filmPrice=CheckTools.getFilmPrice(buyInfo[0]);//获得票价
                List<Seats> seatsList=scheduleService.selectBuyTicketsSeats(buyInfo);
                PrintTools.printBuyTicket(seatsList);//打印座位信息
                int[] seat=PrintTools.getBuySeatInfo();//获得选择的座位信息
                Seats buySeat= CheckTools.checkSeats(seatsList,seat);//校验选择的座位
                int accountBalance=CheckTools.getAccountBalance(accountID);//获得账户余额
                if(accountBalance<filmPrice){
                    System.out.print("账户余额不足，请先充值！");
                }else {
                    boolean flg=PrintTools.checkBuyChoose();
                    if(flg){
                        accountBalance-=filmPrice;
                        //更新账户余额
                        accountService.updateAccountBalance(accountID,accountBalance);
                        System.out.print("购买成功！");
                        //更新座位状态
                        buySeat.setIsSell(1);
                        seatsService.updateSeatsInfo(buySeat);
                        String newT=buyInfo[0]+"_"+buyInfo[1]+".txt";
                        File newTickets=new File("D:/IdeaProject/Studios/tickets/"+newT);
                        BufferedWriter bw=null;
                        if(!newTickets.exists()){
                            try {
                                newTickets.createNewFile();
                                bw= IOTools.getWriter(newTickets,true);
                                bw.write(buySeat.toString());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }finally {
                                try {
                                    bw.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }


                    }else{
                        System.out.print("放弃选择，购买失败！");
                    }
                }
                break;
            case 5://退出
                break;
            default:
                System.out.println("输入错误！");
                break;
        }
    }
}
