package com.Charles.JavaProject.dao;

import com.Charles.JavaProject.entity.Films;

import java.util.List;

/**
 * 上映电影数据dao类
 * Created by Charles on 2017/7/2.
 */
public interface FilmDao {
    /**
     * 查询所有上映电影信息
     * @return
     */
    List<Films> selectFilms();
    
    /**
     * 新增上映电影
     * @return filmID:返回新增的上映电影id
     */
    void addNewFilm(Films film);
}
