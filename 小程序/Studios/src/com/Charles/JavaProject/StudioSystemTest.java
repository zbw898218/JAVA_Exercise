package com.Charles.JavaProject;

import com.Charles.JavaProject.views.Studios;

/**
 * 系统测试类
 * Created by Charles on 2017/7/2.
 */
public class StudioSystemTest {
    public static void main(String[] args){
        Studios studios=new Studios();
        studios.start();
        int accountID=studios.getAccountID();
        if(accountID!=0){
            studios.manager(accountID);
        }
        
    }
}
