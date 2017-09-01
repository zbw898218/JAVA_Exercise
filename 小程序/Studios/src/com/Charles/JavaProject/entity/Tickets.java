package com.Charles.JavaProject.entity;

/**
 * 电影票类
 * Created by Charles on 2017/7/1.
 */
public class Tickets extends Films{
    /**
     * filmID:电影id
     * cinemaID：电影院ID
     * videoHallID:影厅ID
     * dayID:上映日期ID
     * timeID：上映时间ID
     * seatID：座位ID
     * isSell：是否售出：1.售出 0.没有
     */
    private int filmID;
    private int cinemaID;
    private int videoHallID;
    private int dayID;
    private int timeID;
    private int seatID;
    private int isSell;
    
    public Tickets() {
    }
    
    public Tickets(int filmID, String filmName, int filmPrice, int filmID1, int cinemaID, int videoHallID, int dayID, int timeID, int seatID, int isSell) {
        super(filmID, filmName, filmPrice);
        this.filmID = filmID1;
        this.cinemaID = cinemaID;
        this.videoHallID = videoHallID;
        this.dayID = dayID;
        this.timeID = timeID;
        this.seatID = seatID;
        this.isSell = isSell;
    }
    
    public Tickets(int cinemaID, int videoHallID, int dayID, int timeID, int seatID, int isSell) {
        this.cinemaID = cinemaID;
        this.videoHallID = videoHallID;
        this.dayID = dayID;
        this.timeID = timeID;
        this.seatID = seatID;
        this.isSell = isSell;
    }
    
    public Tickets(int filmID, String filmName, int filmPrice, int cinemaID, int videoHallID, int dayID, int timeID, int seatID, int isSell) {
        super(filmID, filmName, filmPrice);
        this.cinemaID = cinemaID;
        this.videoHallID = videoHallID;
        this.dayID = dayID;
        this.timeID = timeID;
        this.seatID = seatID;
        this.isSell = isSell;
    }
    
    public Tickets(int filmID, String filmName, int filmPrice) {
        super(filmID, filmName, filmPrice);
    }
    
    @Override
    public int getFilmID() {
        return filmID;
    }
    
    @Override
    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }
    
    public int getCinemaID() {
        return cinemaID;
    }
    
    public void setCinemaID(int cinemaID) {
        this.cinemaID = cinemaID;
    }
    
    public int getVideoHallID() {
        return videoHallID;
    }
    
    public void setVideoHallID(int videoHallID) {
        this.videoHallID = videoHallID;
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
    
    public int getSeatID() {
        return seatID;
    }
    
    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }
    
    public int getIsSell() {
        return isSell;
    }
    
    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }
    
    @Override
    public String toString() {
        return "电影票信息{" +
                "filmID=" + filmID +
                ", cinemaID=" + cinemaID +
                ", videoHallID=" + videoHallID +
                ", dayID=" + dayID +
                ", timeID=" + timeID +
                ", seatID=" + seatID +
                ", isSell=" + isSell +
                '}';
    }
}
