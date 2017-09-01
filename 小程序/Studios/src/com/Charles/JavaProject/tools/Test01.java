package com.Charles.JavaProject.tools;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

/**
 * Created by Charles on 2017/7/2.
 */
public class Test01 {
    public static void main(String[] args){
    
        Date date=new Date();
        String dats="yyyy-MM-dd";
        SimpleDateFormat sdf=new SimpleDateFormat(dats);
        String st=sdf.format(date);
        System.out.print(st);
    }
}
