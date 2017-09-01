package com.Charles.JavaProject.entity;

import com.Charles.JavaProject.entity.Cinema;

/**
 * 影院排期表
 * Created by Charles on 2017/7/1.
 */
public class Schedule  {
    /**
     * cinemaID:上映影院id
     * videoHallID：上映影厅id
     * dayID：上映日期表
     * timeID：上映时期表
     * filmID：上映电影id
     */
    private int cinemaID;
    private int videoHallID;
    private int dayID;
    private int timeID;
    private int filmID;
    
    
    public Schedule() {
    }
    public Schedule(int cinemaID, String cinemaName, String cinemaAddress) {
    }
    
    public Schedule(int cinemaID, int videoHallID, int dayID, int timeID, int filmID) {
        this.cinemaID = cinemaID;
        this.videoHallID = videoHallID;
        this.dayID = dayID;
        this.timeID = timeID;
        this.filmID = filmID;
    }
    
    public int getCinemaID() {
        return cinemaID;
    }
    
    public void setCinemaID(int cinemaID) {
        this.cinemaID = cinemaID;
    }
    
    public int getFilmID() {
        return filmID;
    }
    
    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }
    
    public int getDayID() {
        return dayID;
    }
    
    public void setDayID(int dayID) {
        this.dayID = dayID;
    }
    
    public int getTimeID() {
        return timeID;
    }
    
    public void setTimeID(int timeID) {
        this.timeID = timeID;
    }
    
    public int getVideoHallID() {
        return videoHallID;
    }
    
    public void setVideoHallID(int videoHallID) {
        this.videoHallID = videoHallID;
    }
    
    @Override
    public String toString() {
        return "影院排期表{" +
                "cinemaID=" + cinemaID +
                ", dayID=" + dayID +
                ", timeID=" + timeID +
                ", filmID=" + filmID +
                ", videoHallID=" + videoHallID +
                '}';
    }
}
