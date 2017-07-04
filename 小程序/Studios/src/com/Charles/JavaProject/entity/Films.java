package com.Charles.JavaProject.entity;

/**
 * 新上映电影对象类
 * Created by Charles on 2017/7/1.
 */
public class Films {
    /**
     * filmID:电影id
     * filmName:电影名称
     * filmPrice：电影票价
     */
    private int filmID;
    private String filmName;
    private int filmPrice;
    
    public Films() {
    }
    
    public Films(int filmID, String filmName, int filmPrice) {
        this.filmID = filmID;
        this.filmName = filmName;
        this.filmPrice = filmPrice;
    }
    
    public Films(String filmName, int filmPrice) {
        this.filmName = filmName;
        this.filmPrice = filmPrice;
    }
    
    public int getFilmID() {
        return filmID;
    }
    
    public void setFilmID(int filmID) {
        this.filmID = filmID;
    }
    
    public String getFilmName() {
        return filmName;
    }
    
    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }
    
    public int getFilmPrice() {
        return filmPrice;
    }
    
    public void setFilmPrice(int filmPrice) {
        this.filmPrice = filmPrice;
    }
    
    @Override
    public String toString() {
        return "电影信息{" +
                "filmID=" + filmID +
                ", filmName='" + filmName + '\'' +
                ", filmPrice=" + filmPrice +
                '}';
    }
}
