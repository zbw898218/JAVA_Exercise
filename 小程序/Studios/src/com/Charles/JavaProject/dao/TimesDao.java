package com.Charles.JavaProject.dao;

import com.Charles.JavaProject.entity.Times;

import java.util.List;

/**
 * 上映时段dao
 * Created by Charles on 2017/7/2.
 */
public interface TimesDao {
    /**
     * 查询上映时段方法
     * @return
     */
    List<Times> selectTimes();
}
