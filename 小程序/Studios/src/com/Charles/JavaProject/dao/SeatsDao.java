package com.Charles.JavaProject.dao;

import com.Charles.JavaProject.entity.Schedule;
import com.Charles.JavaProject.entity.Seats;

import java.util.List;

/**
 * 电影座位类
 * Created by Charles on 2017/7/2.
 */
public interface SeatsDao {
    /**
     * 查询座位方法
     * 将可以购买的座位以集合的形式返回
     * @return
     */
    List<Seats> selectSeats(Schedule schedule);
    
    /**
     * 更新座位信息
     * @param buySeat
     */
    void updateSeats(Seats buySeat);
}
