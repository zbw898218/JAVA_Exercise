package com.Charles.JavaProject.entity;

/**
 * 电影院类
 * Created by Charles on 2017/7/1.
 */
public class Cinema {
    /**
     * cinemaID：电影院id
     * cinemaName：电影院名称
     * cinemaAddress：电影院地址
     */
    private int cinemaID;
    private String cinemaName;
    private String cinemaAddress;
    private int cinemaMoney;
    public Cinema() {
    }
    
    public Cinema(int cinemaID, String cinemaName, String cinemaAddress, int cinemaMoney) {
        this.cinemaID = cinemaID;
        this.cinemaName = cinemaName;
        this.cinemaAddress = cinemaAddress;
        this.cinemaMoney = cinemaMoney;
    }
    
    public Cinema(int cinemaID, String cinemaName, String cinemaAddress) {
        this.cinemaID = cinemaID;
        this.cinemaName = cinemaName;
        this.cinemaAddress = cinemaAddress;
    }
    
    public int getCinemaMoney() {
        return cinemaMoney;
    }
    
    public void setCinemaMoney(int cinemaMoney) {
        this.cinemaMoney = cinemaMoney;
    }
    
    public int getCinemaID() {
        return cinemaID;
    }
    
    public void setCinemaID(int cinemaID) {
        this.cinemaID = cinemaID;
    }
    
    public String getCinemaName() {
        return cinemaName;
    }
    
    public void setCinemaName(String cinemaName) {
        this.cinemaName = cinemaName;
    }
    
    public String getCinemaAddress() {
        return cinemaAddress;
    }
    
    public void setCinemaAddress(String cinemaAddress) {
        this.cinemaAddress = cinemaAddress;
    }
    
    @Override
    public String toString() {
        return "电影院信息{" +
                "cinemaID=" + cinemaID +
                ", cinemaName='" + cinemaName + '\'' +
                ", cinemaAddress='" + cinemaAddress + '\'' +
                ", cinemaMoney=" + cinemaMoney +
                '}';
    }
}
