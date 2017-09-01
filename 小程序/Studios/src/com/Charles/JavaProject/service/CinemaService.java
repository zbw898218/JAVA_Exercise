package com.Charles.JavaProject.service;

import com.Charles.JavaProject.dao.CinemaDao;
import com.Charles.JavaProject.entity.Cinema;
import com.Charles.JavaProject.impdao.CinemaImpDao;

import java.util.Iterator;
import java.util.List;

/**
 * 电影院逻辑类
 * Created by Charles on 2017/7/2.
 */
public class CinemaService {
    CinemaDao cinemaDao=new CinemaImpDao();
    
    public void selectCinemas(){
        List<Cinema> cinemaList=cinemaDao.selectCinemas();
        System.out.println("*****************************************************");
        Iterator<Cinema> it=cinemaList.iterator();
        while(it.hasNext()){
            Cinema cinema=it.next();
            String cinemaName=cinema.getCinemaName();
            String cinemaAddress=cinema.getCinemaAddress();
            System.out.println("电影院："+cinemaName+" 地址："+cinemaAddress);
        }
        System.out.println("*****************************************************");
    }
}
