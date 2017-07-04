package com.charles.tools;

import java.io.*;
import java.util.Iterator;
import java.util.List;

/**
 * 工具类，提供读写流对象以供操作和关闭
 * Created by Charles on 2017/6/27
 */
public class Tools {
    /**
     * 提供可被操作的文件对象
     */
    public static File PET_FILE=new File("pet.txt");
    public static File SHOP_FILE=new File("shop.txt");
    public static File CUSTOMER_FILE=new File("customer.txt");
    public static File PET_TYPE_FILE=new File("petType.txt");
    public static File TRADE_FILE=new File("trade.txt");
    public static File USER_FILE=new File("user.txt");

    /**
     * 获得输入流的方法
     * @param file
     * @return BufferedReader字符缓冲流
     * @throws FileNotFoundException
     */
    public static BufferedReader reader(File file)throws FileNotFoundException{
        BufferedReader br=new BufferedReader(new FileReader(file));
        return br;
    }

    /**
     * 获得输出流的方法，追加写入
     * @param file
     * @return
     * @throws IOException
     */
    public static BufferedWriter writer(File file)throws IOException{
        BufferedWriter bw=new BufferedWriter(new FileWriter(file,true));
        return bw;
    }
    

}
