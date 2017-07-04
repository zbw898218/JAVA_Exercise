package DesignMode.FectoryMode.Example;

import java.io.File;
import java.io.FileInputStream;

/**
 * 定义读文本文件具体类
 * Created by Charles on 2017/6/7
 */
public class TextRead implements IRead<String > {
    @Override
    public String read(String... in) {//String... in:表示可输入0或多个参数
        String result= null;
        try{
            File file=new File(in[0]);//int[0]:表示文件名称
            long len=file.length();//文本长度
            FileInputStream ips=new FileInputStream(in[0]);
            byte[] buf=new byte[(int)len];//缓冲区大小等于文件长度
            ips.read(buf);//将文件读入byte数组中
            result=new String(buf,in[1]);//in[1]:代表输入的编码格式，按其编码转换成可见字符串
            ips.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
