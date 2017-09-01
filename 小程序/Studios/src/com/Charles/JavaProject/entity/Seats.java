package com.Charles.JavaProject.entity;

/**
 * 座位类
 * Created by Charles on 2017/7/1.
 */
public class Seats extends VideoHall{
    /**
     * videoHallID：影厅id
     * seatID:座位id
     * columnID：横排id
     * rowID：纵列id
     * isSell:是否售出 0：没有 1：售出
     */
    private int videoHallID;
    private int seatID;
    private int columnID;
    private int rowID;
    private int isSell;
    
    public Seats() {
    }
    
    public Seats(int cinemaID, int videoHallID, String videoHallName, int videoHallID1, int seatID, int columnID, int rowID) {
        super(cinemaID, videoHallID, videoHallName);
        this.videoHallID = videoHallID1;
        this.seatID = seatID;
        this.columnID = columnID;
        this.rowID = rowID;
    }
    
    public Seats(int videoHallID, int seatID, int columnID, int rowID, int isSell) {
        this.videoHallID = videoHallID;
        this.seatID = seatID;
        this.columnID = columnID;
        this.rowID = rowID;
        this.isSell = isSell;
    }
    
    public Seats(int cinemaID, int videoHallID, String videoHallName, int videoHallID1, int seatID, int columnID, int rowID, int isSell) {
        super(cinemaID, videoHallID, videoHallName);
        this.videoHallID = videoHallID1;
        this.seatID = seatID;
        this.columnID = columnID;
        this.rowID = rowID;
        this.isSell = isSell;
    }
    
    public Seats(int cinemaID, int videoHallID, String videoHallName, int seatID, int columnID, int rowID) {
        super(cinemaID, videoHallID, videoHallName);
        this.seatID = seatID;
        this.columnID = columnID;
        this.rowID = rowID;
    }
    public Seats(int seatID, int columnID, int rowID) {
        this.seatID = seatID;
        this.columnID = columnID;
        this.rowID = rowID;
    }
    
    public int getIsSell() {
        return isSell;
    }
    
    public void setIsSell(int isSell) {
        this.isSell = isSell;
    }
    
    @Override
    public int getVideoHallID() {
        return videoHallID;
    }
    
    @Override
    public void setVideoHallID(int videoHallID) {
        this.videoHallID = videoHallID;
    }
    
    public int getSeatID() {
        return seatID;
    }
    
    public void setSeatID(int seatID) {
        this.seatID = seatID;
    }
    
    public int getColumnID() {
        return columnID;
    }
    
    public void setColumnID(int columnID) {
        this.columnID = columnID;
    }
    
    public int getRowID() {
        return rowID;
    }
    
    public void setRowID(int rowID) {
        this.rowID = rowID;
    }
    
    @Override
    public String toString() {
        return "座位信息{" +
                "videoHallID=" + videoHallID +
                ", seatID=" + seatID +
                ", columnID=" + columnID +
                ", rowID=" + rowID +
                ", isSell=" + isSell +
                '}';
    }
}
