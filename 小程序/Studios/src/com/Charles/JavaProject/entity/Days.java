package com.Charles.JavaProject.entity;


/**
 * 日期类
 * Created by Charles on 2017/7/1.
 */
public class Days {
    /**
     * dayID：上映日期id
     * dayName：上映日期
     */
    private int dayID;
    private String dayName;
    
    public Days() {
    }
    public Days(int dayID, String dayName) {
        this.dayID = dayID;
        this.dayName = dayName;
    }
    public int getDayID() {
        return dayID;
    }
    public void setDayID(int dayID) {
        this.dayID = dayID;
    }
    public String getDayName() {
        return dayName;
    }
    public void setDayName(String dayName) {
        this.dayName = dayName;
    }
    @Override
    public String toString() {
        return "上映日期{" +
                "dayID=" + dayID +
                ", dayName='" + dayName + '\'' +
                '}';
    }
}
