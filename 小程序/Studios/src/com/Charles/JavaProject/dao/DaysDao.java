package com.Charles.JavaProject.dao;

import com.Charles.JavaProject.entity.Days;

import java.util.List;

/**
 * 上映日期类
 * Created by Charles on 2017/7/2.
 */
public interface DaysDao {
    /**
     * 查询上映日期
     * @return
     */
    List<Days> selectDays();
}
