package com.Charles.JavaProject.entity;

/**
 * Times:时间段类
 * Created by Charles on 2017/7/1.
 */
public class Times {
    /**
     *timeID：时段ID
     * timeName:时段名称
     */
    private int timeID;
    private String timeName;
    
    public Times(int timeID, String timeName) {
        this.timeID = timeID;
        this.timeName = timeName;
    }
    
    public Times() {
    
    }
    
    public int getTimeID() {
        return timeID;
    }
    
    public void setTimeID(int timeID) {
        this.timeID = timeID;
    }
    
    public String getTimeName() {
        return timeName;
    }
    
    public void setTimeName(String timeName) {
        this.timeName = timeName;
    }
    
    @Override
    public String toString() {
        return "上映时段{" +
                "timeID=" + timeID +
                ", timeName='" + timeName + '\'' +
                '}';
    }
}
