package com.Charles.JavaProject.tools;

import java.io.*;

/**
 * IO工具类，提供输入输出流
 * Created by Charles on 2017/7/1.
 */
public class IOTools {
    /**
     * 获得输出流
     * @param file
     * @return 输出流
     */
    public static BufferedReader getReader(File file){
        BufferedReader br=null;
        try {
            br=new BufferedReader(new InputStreamReader(new FileInputStream(file)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return br;
    }
    
    /**
     * 获得输入流
     * @param file :输入的文件 flg：是否追加方式写入
     * @return 输入流
     */
    public static BufferedWriter getWriter(File file,Boolean flg){
        BufferedWriter bw=null;
        try {
            bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file,flg)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bw;
    }
    
    
}
