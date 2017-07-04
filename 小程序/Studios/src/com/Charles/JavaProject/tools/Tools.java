package com.Charles.JavaProject.tools;

/**
 * Created by Charles on 2017/7/2.
 */
public class Tools {
    /**
     * 拆分字符串方法
     * @param string
     * @return
     */
    public static String[] cgString(String string){
        String sts=string.substring(string.indexOf("{")+1,string.indexOf("}"));;
        String[] strings=sts.split(",");
        return strings;
    }
}
