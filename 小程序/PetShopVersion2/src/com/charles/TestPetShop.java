package com.charles;

import com.charles.entity.Pet;
import com.charles.entity.Trade;
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
    static int masterType=0;
    static boolean login=false;
    public static void start(){
        //展示部分正在出售的宠物信息
        int check= PrintTools.printIndex();
        int count=0;
        
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
                    while(!login&&count<3){
                        System.out.println(login);
                        login=register();
                        count++;
                        if(count>=3){
                            break;
                        }
                    }
                    masterType=MasterService.getMasterType(masterID);
                    if(masterType==1){
                        CommanagerUI();
                    }else{
                        CustmanagerUI();
                    }
                    break;
                //登录
                case 3:
                    while(!login&&count<3){
                        login=login();
                        count++;
                        if(count>=3){
                            break;
                        }
                    }
                    masterType=MasterService.getMasterType(masterID);
                    if(masterType==1){
                        CommanagerUI();
                    }else{
                        CustmanagerUI();
                    }
                    break;

                case 4:
                    login=false;
                    System.out.println("谢谢惠顾！");
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
        if(masterID==0||masterID==-1){
            System.out.println("用户名不可用，注册失败！");
        }else{
            reg=true;
            System.out.println("注册成功！");
        }
        return reg;
    }
    /**
     * 登录方法
     * @return
     */
    public static boolean login(){
        boolean flg=false;
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
    
    
    /**
     * 顾客身份注册或登录成功后，跳转至管理界面
     * 提供购买、出售等通用选项
     */
    public static void CustmanagerUI(){
        int check=PrintTools.CustmanagerUI();
        int petID=0;
        switch (check){
            //购买宠物
            case 1:
                petID=PrintTools.getBuyPetInfo();
                boolean answ=buyPet(petID);
                if(answ){
                    System.out.println("恭喜，购买成功！");
                }
                break;
            //出售宠物
            case 2:
                petID=PrintTools.getBuyPetInfo();
                int isOK=sellPet(petID);
                if(isOK==1){
                    System.out.println("抱歉，你没有该宠物，无法上架！");
                }else if(isOK==2){
                    System.out.println("该宠物正在售卖中，无法再次上架！");
                }else if(isOK==3){
                    System.out.println("恭喜，上架成功！");
                }else{
                    System.out.println("系统错误！");
                }
                break;
            //退出
            case 3:
                login=false;
                System.out.println("谢谢惠顾！");
                break;
            default:
                break;
        }
    }
    /**
     * 商家注册或登录成功后，跳转至管理界面
     * 提供购买、出售、培育等通用选项
     */
    public static void CommanagerUI(){
        int check=PrintTools.CommanagerUI();
        int petID=0;
        switch (check){
            //购买宠物
            case 1:
                petID=PrintTools.getBuyPetInfo();
                boolean answ=buyPet(petID);
                if(answ){
                    System.out.println("恭喜，购买成功！");
                }
                break;
            //出售宠物
            case 2:
                petID=PrintTools.getBuyPetInfo();
                int isOK=sellPet(petID);
                if(isOK==1){
                    System.out.println("抱歉，你没有该宠物，无法上架！");
                }else if(isOK==2){
                    System.out.println("该宠物正在售卖中，无法再次上架！");
                }else if(isOK==3){
                    System.out.println("恭喜，上架成功！");
                }else{
                    System.out.println("系统错误！");
                }
                break;
            //培育宠物
            case 3:
                String[] newPetInfo=PrintTools.getNewPetInfo();
                int OK=createNewPet(newPetInfo);
                if(OK==1){
                    System.out.println("培育成功！");
                }else if(OK==0){
                    System.out.println("培育失败！");
                }
                break;
            //退出
            case 4:
                login=false;
                System.out.println("谢谢惠顾！");
                break;
            default:
                break;
        }
    }
    /**
     * 购买宠物的方法
     * 1.控制台获得购买宠物petID
     * 2.获得目标宠物price，原主人mastID
     * 3.修改pet表中目标宠物 mastID和onSell，更新宠物表
     * 4.修改master表 oldMasterMoney+price newMastMoney-price，更新master表
     * 5.生成trade记录，写入master表
     * @param petID
     */
    public static boolean buyPet(int petID){
        boolean isOK=false;
        Pet pet=PetService.selecetOnSellPet(petID);
        int oldMasterID=pet.getMasterID();
        int price=pet.getPrice();
        PetService.updatePetInfo(petID,masterID);//更新宠物表
        MasterService.updateMasterInfo(oldMasterID,masterID,price);//更新master表
        Trade trade=new Trade(petID,price,oldMasterID,masterID,1);//生成新交易记录对象，交易id业务层确定
        isOK=TradeService.addNewTrade(trade);
        return isOK;
    }
    
    /**
     *出售宠物的方法：模拟商品上架的过程，只修改目标宠物的onSell状态
     * 1.控制台获得出售宠物petID
     * 2.校验目标宠物是否正在售卖中以及是否属于自己
     * 3.修改pet表中目标宠物 onSell=1，将更新宠物表
     * 5.生成trade记录，写入master表
     * @param petID 指定出售宠物id
     * @return isOK:上架成功与否
     */
    public static int sellPet(int petID){
        int isOK=0;
        Pet pet1=PetService.selecetInSellPet(petID);
        if(pet1!=null){
            int price=pet1.getPrice();
            isOK=PetService.sellPet(petID,price,masterID);
        }
        return isOK;
    }

    /**
     * 培育宠物的方法：按需求，只有masterType=1即商店才能培育
     * 1.控制台获取需要培育的宠物基础属性：typeID，名字，颜色，价格，
     * 2.校验master身份信息
     * 3.遍历pet对象表，生成新petID，
     * 4.将新pet对象追加写入pet表中
     * @param newPetInfo 宠物基础属性
     * @return
     */
    public static int createNewPet(String[] newPetInfo ){
        int isOK=0;
        int masterTypeID=MasterService.checkMasterType(masterID);
        if(masterTypeID==1){
            int newPetID=PetService.getNewPetID();
            String newPet=newPetID+","+newPetInfo[0]+","+newPetInfo[1]+","+1+","+newPetInfo[2]+","+newPetInfo[3]+","+0+","+masterID;
            PetService.updatePetInfo(newPet);
            isOK=1;
        }else{
            System.out.println("对不起，你不具备培育新宠物的资格！");
        }
        return isOK;
    }
    public static void main(String[] args){
        start();
    }

}
