package com.Charles.JavaProject.entity;

/**
 * 影厅类
 * Created by Charles on 2017/7/1.
 */
public class VideoHall {
    /**
     * cinemaID:电影院ID
     * videoHallID:影厅id
     * videoHallName:影厅名称
     */
    private int cinemaID;
    private int videoHallID;
    private String videoHallName;
    
    public VideoHall() {
    }
    
    public VideoHall(int cinemaID, int videoHallID, String videoHallName) {
        this.cinemaID = cinemaID;
        this.videoHallID = videoHallID;
        this.videoHallName = videoHallName;
    }
    
    public void setCinemaID(int cinemaID) {
        this.cinemaID = cinemaID;
    }
    
    public void setVideoHallID(int videoHallID) {
        this.videoHallID = videoHallID;
    }
    
    public void setVideoHallName(String videoHallName) {
        this.videoHallName = videoHallName;
    }
    
    public int getCinemaID() {
        return cinemaID;
    }
    
    public int getVideoHallID() {
        return videoHallID;
    }
    
    public String getVideoHallName() {
        return videoHallName;
    }
    
    @Override
    public String toString() {
        return "影厅信息{" +
                "cinemaID=" + cinemaID +
                ", videoHallID=" + videoHallID +
                ", videoHallName='" + videoHallName + '\'' +
                '}';
    }
}
