package com.Charles.JavaProject.impdao;

import com.Charles.JavaProject.dao.FilmDao;
import com.Charles.JavaProject.entity.Films;
import com.Charles.JavaProject.jdbc.MyConnection;
import com.Charles.JavaProject.tools.SQLTools;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 电影数据交换类
 * Created by Charles on 2017/7/2.
 */
public class FilmImpDao implements FilmDao {
    MyConnection myConnection=new MyConnection();
    @Override
    public List<Films> selectFilms() {
        List<Films> filmsList=new ArrayList<>();
        Connection myCon=myConnection.getConnection();
        Films films=null;
        Statement stm=null;
        ResultSet rst=null;
        try {
            stm=myCon.createStatement();
            rst=stm.executeQuery(SQLTools.SELECT_FILMS);
            while(rst.next()){
                int filmID=rst.getInt(1);
                String filmName=rst.getString(2);
                int filmPrice=rst.getInt(3);
                films=new Films(filmID,filmName,filmPrice);
                filmsList.add(films);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                myCon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return filmsList;
    }
    
    @Override
    public void addNewFilm(Films film) {
        Connection myCon=myConnection.getConnection();
        PreparedStatement pst=null;
        try {
            pst=myCon.prepareStatement(SQLTools.INSERT_FILMS);
            pst.setInt(1,film.getFilmID());
            pst.setString(2,film.getFilmName());
            pst.setInt(3,film.getFilmPrice());
            pst.addBatch();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try {
                pst.executeBatch();
                myCon.commit();
                myCon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
