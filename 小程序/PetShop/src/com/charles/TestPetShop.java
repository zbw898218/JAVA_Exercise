package com.charles;

import com.charles.entity.Account;
import com.charles.entity.Master;
import com.charles.entity.Pet;
import com.charles.entity.Trade;
import com.charles.service.AccountService;
import com.charles.service.MasterService;
import com.charles.service.PetService;
import com.charles.service.TradeService;
import com.charles.tools.PrintTools;

import java.util.List;

/**
 * Created by Charles on 2017/6/27
 */
public class TestPetShop {
    /**
     * 启动程序
     */
    static int masterID=0;
    static boolean login=false;
    public static void start(){

        //展示部分正在出售的宠物信息
        int check= PrintTools.printIndex();
        switch (check){
            //查询需要的宠物信息
            case 1:
                String petType=PrintTools.getPetInfo();
                List<Pet> petTypes=PetService.selecetNeedPet(petType);
                if(petTypes.size()==0){
                    System.out.println("抱歉，暂时没有这种宠物！");
                }else{
                    PrintTools.printList(petTypes);
                }
                break;
            //注册
            case 2:
                while(!login){
                    login=register();
                }

                break;
            //登录
            case 3:
                while(!login){
                    login=login();
                }
                break;
            default:
                break;
        }
    }

    /**
     * 注册方法
     * @return
     */
    public static boolean register(){
        boolean reg=false;
        String[] regInfo=PrintTools.getRegInfo();
        masterID=MasterService.regMaster(regInfo);
        if(masterID!=0){
            System.out.println("注册成功！");
            login=true;
        }else{
            System.out.println("注册失败！");
        }
        return reg;
    }
    /**
     * 登录方法
     * @return
     */
    public static boolean login(){
        boolean flg=false;
//        System.out.println("抱歉，请先行登录！");
        String[] loginInfo=PrintTools.getLoginInfo();
        masterID= MasterService.checkLoginInfo(loginInfo);
        if(masterID!=0){
            System.out.println("登录成功！");
            flg=true;
        }else{
            System.out.println("抱歉，用户名或密码错误！");
        }
        return flg;
    }
    public static void buyPet(int petID){

        Pet buyPet=PetService.selecetOnePet(petID);//获得要购买的宠物对象
        System.out.println(buyPet);
        if(buyPet!=null){
//            PetService.updatePetInfo(account,buyPet);//刷新宠物表信息
//            AccountService.buyPet(account,buyPet);//刷新账户信息
//            TradeService.writeTradeLog(account,buyPet);//将交易记录写入交易表
            System.out.println("购买成功！");
        }
    }
    public static void main(String[] args){
        start();
    }

}
