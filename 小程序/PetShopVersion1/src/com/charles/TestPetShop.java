package com.charles;

import com.charles.entity.Pet;
import com.charles.entity.Shop;
import com.charles.entity.User;
import com.charles.service.PetService;
import com.charles.service.UserService;
import com.charles.tools.PrintTools;

import java.util.List;

/**
 * Created by Charles on 2017/6/27
 */
public class TestPetShop {
    /**
     * 启动程序
     */
    public static void start(){
        int firstCheck=PrintTools.printIndex();
        switch (firstCheck){
            case 1:
                int regType=PrintTools.getRegisterType();
                if(regType==1||regType==0){
                    String[] regInfo=PrintTools.getRegisterInfo();
                    boolean reg=UserService.register(regType,regInfo);
                    if(reg){
                        System.out.println("注册成功！");
                        managerUI();
                    }else{
                        System.out.println("用户名已存在，注册失败！");
                    }
                    break;
                }else{
                    System.out.println("选择注册的类型错误！");
                }
                
                
            case 2:
                String[] loginInfo=PrintTools.getLoginInfo();
                boolean login=UserService.login(loginInfo);
                if(login){
                    System.out.println("登录成功！");
                    managerUI();
                }else{
                    System.out.println("登录失败！");
                }
                break;
            case 3:
                break;
            default:
                break;
        }
    }
    
    /**
     * 登陆后管理界面
     */
    public static void managerUI(){
        int myCheck=PrintTools.printManagerUI();
        switch (myCheck){
            case 1:
                List<User> shops=UserService.selectShops();
                PrintTools.printList(shops);
                break;
            case 2:
                List<Pet> pets= PetService.selectPets();
                PrintTools.printList(pets);
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
            default:
                System.out.print("输入错误！");
                break;
        }
    }
    public static void main(String[] args){
        start();
    }

}
