package com.Charles.JavaProject.dao;

import com.Charles.JavaProject.entity.VideoHall;

import java.util.List;

/**
 * Created by Charles on 2017/7/2.
 */
public interface VideoHallDao {
    List<VideoHall> selectVideoHalls();
}
