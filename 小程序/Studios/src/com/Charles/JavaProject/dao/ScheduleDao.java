package com.Charles.JavaProject.dao;

import com.Charles.JavaProject.entity.Schedule;

import java.util.List;

/**
 * 影院排期表dao
 * 提供查询所有电影排期信息方法
 * Created by Charles on 2017/7/2.
 */
public interface ScheduleDao {
    /**
     * 查询所有电影排期信息
     * @return
     */
    List<Schedule> selectSchedules();
}
