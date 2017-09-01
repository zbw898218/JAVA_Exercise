package com.Charles.JavaProject.service;

import com.Charles.JavaProject.dao.*;
import com.Charles.JavaProject.entity.*;
import com.Charles.JavaProject.impdao.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 上映电影排期逻辑类
 * Created by Charles on 2017/7/2.
 */
public class ScheduleService {
    SeatsDao seatsDao=new SeatsImpDao();
    ScheduleDao scheduleDao=new ScheduleImpDao();
    CinemaDao cinemaDao=new CinemaImpDao();
    DaysDao daysDao=new DaysImpDao();
    TimesDao timesDao=new TimesImpDao();
    FilmDao filmDao=new FilmImpDao();
    VideoHallDao videoHallDao=new VideoHallImpDao();
    /**
     * 查询所有上映电影信息
     * 遍历每家影院的排期表，获得所有电影上映信息
     */
    public void selectAllFilmsInfo(){
        List<Schedule> scheduleList=scheduleDao.selectSchedules();
        List<Cinema> cinemaList=cinemaDao.selectCinemas();
        List<Days> daysList=daysDao.selectDays();
        List<Times> timesList=timesDao.selectTimes();
        List<Films> filmsList=filmDao.selectFilms();
        List<VideoHall> videoHallList=videoHallDao.selectVideoHalls();
        Iterator<Schedule> it=scheduleList.iterator();
        
        String cinemaName=null;
        String dayName=null;
        String timeName=null;
        String filmName=null;
        int filmPrice=0;
        String videoHallName=null;
        System.out.println("*****************************************************");
        while(it.hasNext()){
            Schedule tmp=it.next();
            for(int i=0;i<cinemaList.size();i++){
                if(cinemaList.get(i).getCinemaID()==tmp.getCinemaID()){
                    cinemaName=cinemaList.get(i).getCinemaName();
                    break;
                }
            }
            for(int i=0;i<daysList.size();i++){
                if(daysList.get(i).getDayID()==tmp.getDayID()){
                    dayName=daysList.get(i).getDayName();
                    break;
                }
            }
            for(int i=0;i<timesList.size();i++){
                if(timesList.get(i).getTimeID()==tmp.getTimeID()){
                    timeName=timesList.get(i).getTimeName();
                    break;
                }
            }
            for(int i=0;i<filmsList.size();i++){
                if(filmsList.get(i).getFilmID()==tmp.getFilmID()){
                    filmName=filmsList.get(i).getFilmName();
                    filmPrice=filmsList.get(i).getFilmPrice();
                    break;
                }
            }
            for(int i=0;i<videoHallList.size();i++){
                if(videoHallList.get(i).getVideoHallID()==tmp.getVideoHallID()){
                    videoHallName=videoHallList.get(i).getVideoHallName();
                    break;
                }
            }
            System.out.println("影院："+cinemaName+"\t上映日期："+dayName+"\t时段："+timeName+"\t电影名："+filmName+"\t售价"+filmPrice+"\t播放影厅："+videoHallName);
        }
        System.out.println("*****************************************************");
    }
    
    /**
     * 查询指定电影信息
     * @param filmName
     */
    public void selectOneFilmInfo(String filmName){
        List<Schedule> scheduleList=scheduleDao.selectSchedules();
        List<Cinema> cinemaList=cinemaDao.selectCinemas();
        List<Days> daysList=daysDao.selectDays();
        List<Times> timesList=timesDao.selectTimes();
        List<Films> filmsList=filmDao.selectFilms();
        List<VideoHall> videoHallList=videoHallDao.selectVideoHalls();
        Iterator<Films> it=filmsList.iterator();
        int filmID=0;
        boolean flg=false;
        int filmPrice=0;
        String cinemaName=null;
        String dayName=null;
        String timeName=null;
        String videoHallName=null;
        while(it.hasNext()){
            Films tmp=it.next();
            if(tmp.getFilmName().equals(filmName)){
                filmID=tmp.getFilmID();
                filmPrice=tmp.getFilmPrice();
                flg=true;
                break;
            }
        }
        if(flg){
            Iterator<Schedule> its=scheduleList.iterator();
            System.out.println("*****************************************************");
            while(its.hasNext()){
                Schedule tmp=its.next();
                if(tmp.getFilmID()==filmID){
                    for(int i=0;i<cinemaList.size();i++){
                        if(cinemaList.get(i).getCinemaID()==tmp.getCinemaID()){
                            cinemaName=cinemaList.get(i).getCinemaName();
                            break;
                        }
                    }
                    for(int i=0;i<daysList.size();i++){
                        if(daysList.get(i).getDayID()==tmp.getDayID()){
                            dayName=daysList.get(i).getDayName();
                            break;
                        }
                    }
                    for(int i=0;i<timesList.size();i++){
                        if(timesList.get(i).getTimeID()==tmp.getTimeID()){
                            timeName=timesList.get(i).getTimeName();
                            break;
                        }
                    }
                    for(int i=0;i<videoHallList.size();i++){
                        if(videoHallList.get(i).getVideoHallID()==tmp.getVideoHallID()){
                            videoHallName=videoHallList.get(i).getVideoHallName();
                            break;
                        }
                    }
                    System.out.println("影院："+cinemaName+"\t上映日期："+dayName+"\t时段："+timeName+"\t电影名："+filmName+"\t售价"+filmPrice+filmName+"\t播放影厅："+videoHallName);
                }
            }
            System.out.println("*****************************************************");
        }else{
            System.out.println("抱歉，没有查到相关信息！");
        }
    }
    
    public List<Seats> selectBuyTicketsSeats(String[] buyInfo){
        List<Schedule> scheduleList=scheduleDao.selectSchedules();
        List<Cinema> cinemaList=cinemaDao.selectCinemas();
        List<Days> daysList=daysDao.selectDays();
        List<Times> timesList=timesDao.selectTimes();
        List<Films> filmsList=filmDao.selectFilms();
    
        Schedule schedule=null;
        List<Seats> seats=null;
        String filmName=buyInfo[0];
        String cinemaName=buyInfo[1];
        String dayName=buyInfo[2];
        String timeName=buyInfo[3];
        int cinemaID=0;
        int dayID=0;
        int timeID=0;
        int filmsID=0;
        
        for(int i=0;i<cinemaList.size();i++) {//确定影院
            if (cinemaList.get(i).getCinemaName().equals(cinemaName)) {
                cinemaID=cinemaList.get(i).getCinemaID();
                break;
            }
        }
        for(int l=0;l<daysList.size();l++){//确定日期
            if(daysList.get(l).getDayName().equals(dayName)) {
                dayID=daysList.get(l).getDayID();
                break;
            }
        }
        for(int m=0;m<timesList.size();m++){//确定时段
            if(timesList.get(m).getTimeName().equals(timeName)) {
                timeID=timesList.get(m).getTimeID();
                break;
            }
        }
        for(int n=0;n<filmsList.size();n++){//确定电影
            if(filmsList.get(n).getFilmName().equals(filmName)) {
                filmsID=filmsList.get(n).getFilmID();
                break;
            }
        }
        Iterator<Schedule> it=scheduleList.iterator();
        while(it.hasNext()){
            Schedule tmp=it.next();
            if(tmp.getFilmID()==filmsID&&tmp.getCinemaID()==cinemaID&&tmp.getDayID()==dayID&&tmp.getTimeID()==timeID){
                schedule=tmp;
                break;
            }
        }
        if(schedule!=null){
            seats=seatsDao.selectSeats(schedule);
        }else{
            System.out.print("抱歉，您选择的电影该时段没有排片");
        }
        return seats;
    }
}
