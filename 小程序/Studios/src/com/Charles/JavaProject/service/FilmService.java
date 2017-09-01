package com.Charles.JavaProject.service;

import com.Charles.JavaProject.dao.FilmDao;
import com.Charles.JavaProject.entity.Films;
import com.Charles.JavaProject.impdao.FilmImpDao;

import java.util.List;

/**
 * Created by Charles on 2017/7/2.
 */
public class FilmService {
    FilmDao filmDao=new FilmImpDao();
    
    /**
     * 查询电影的逻辑：
     */
    public List<Films> selectFilms(){
        List<Films> filmsList=filmDao.selectFilms();
        return filmsList;
    }
}
