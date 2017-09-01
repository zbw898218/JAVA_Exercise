package com.Charles.JavaProject.service;

import com.Charles.JavaProject.dao.SeatsDao;
import com.Charles.JavaProject.entity.Seats;
import com.Charles.JavaProject.impdao.SeatsImpDao;

/**
 * 影院座位逻辑
 * Created by Charles on 2017/7/2.
 */
public class SeatsService {
    SeatsDao seatsDao=new SeatsImpDao();
    /**
     * 更新座位信息
     * @param buySeat
     */
    public void updateSeatsInfo(Seats buySeat) {
        seatsDao.updateSeats(buySeat);
    }
}
