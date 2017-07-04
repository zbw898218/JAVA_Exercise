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
     * @param account
     * @param pet
     */
    public static void writeTradeLog(Account account, Pet pet){
        List<Trade> tradeList=selectAllTrades();
        int buyTradeID=0;
        if(tradeList.size()==0){
            buyTradeID=1;
        }else{
            buyTradeID=tradeList.get(tradeList.size()-1).getBuyTradeID()+1;
        }
         int petID=pet.getPetID();
         int price=pet.getPrice();
         int accountID=account.getAccountID();
         int tradeType=1;
         String tradeInfo=buyTradeID+","+petID+","+price+","+accountID+","+tradeType;
        TradeDao.writeNew(tradeInfo);
    }
    public static List<Trade> selectAllTrades(){
        List<Trade> tradeList= TradeDao.selectAllTrades();
        return tradeList;
    }
}
