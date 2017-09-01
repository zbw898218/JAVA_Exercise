package com.charles.tools;

import java.io.*;

/**
 * IO工具类
 * 提供获得输入输出流对象方法
 * Created by Charles on 2017/6/28
 */
public class IOTools {
    /**
     * 以追加方式写入，增加账户信息
     * @param file
     * @return
     */
    public static BufferedWriter writer(File file) {
        BufferedWriter bw = null;
        try {

            bw = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return bw;
        }
    }

    /**
     * 以覆盖方式写入,刷新账户表信息
     * @param file
     * @return
     */
    public static BufferedWriter writers(File file) {
        BufferedWriter bw = null;
        try {

            bw = new BufferedWriter(new FileWriter(file, false));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return bw;
        }
    }
    public static BufferedReader reader(File file){
        BufferedReader br=null;
        try {
            br=new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            return br;
        }
    }
}
