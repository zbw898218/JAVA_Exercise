package com.charles.service;

import com.charles.dao.TradeDao;
import com.charles.entity.Account;
import com.charles.entity.Pet;
import com.charles.entity.Trade;

import java.util.List;

/**
 * 交易逻辑类
 * Created by Charles on 2017/6/28
 */
public class TradeService {
    /**
     * 追加新交易记录
     *
     */
    public static boolean addNewTrade(Trade trade){
        boolean isOk=false;
        List<Trade> tradeList=selectAllTrades();
        int buyTradeID=0;
        if(tradeList.size()==0){
            buyTradeID=1;
        }else{
            buyTradeID=tradeList.get(tradeList.size()-1).getBuyTradeID()+1;
        }
         
         String tradeInfo=buyTradeID+","+trade.getPetID()+","+trade.getPrice()+","+trade.getOldMasterID()+","+trade.getNewMasterID()+","+trade.getTradeType();
        TradeDao.writeNew(tradeInfo);
        List<Trade> newTradeList=selectAllTrades();
        if(newTradeList.size()>tradeList.size()){
            isOk=true;
        }
        return isOk;
    }
    public static List<Trade> selectAllTrades(){
        List<Trade> tradeList= TradeDao.selectAllTrades();
        return tradeList;
    }
}
