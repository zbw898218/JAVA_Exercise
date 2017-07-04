package com.Charles.JavaProject.dao;

import com.Charles.JavaProject.entity.Cinema;

import java.util.List;

/**
 * 电影院dao类
 * 新增、查询电影院信息
 * Created by Charles on 2017/7/2.
 */
public interface CinemaDao {
    /**
     * 查询所有电影院信息
     * @return
     */
    List<Cinema> selectCinemas();
    
    /**
     * 增加限制：AccountType=0(平台超级管理员才能增加)
     * 增加新的电影院信息
     * 返回 新增的cinemaID
     */
    int newCinema(Cinema cinema);
}
