package com.charles.dao;

import com.charles.entity.Trade;
import com.charles.tools.GetFile;
import com.charles.tools.IOTools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
/**
 * Created by Charles on 2017/6/28
 */
public class TradeDao {
    /**
     * 获取所有交易记录，以集合返回
     * @return
     */
    public static List<Trade> selectAllTrades(){
        List<Trade> tradeList=new ArrayList<>();
        Trade trade=null;
        File file=new File(GetFile.TRADE_FILE_NAME);
        BufferedReader br= IOTools.reader(file);
        try {
            while (br.ready()){
                String tmp=br.readLine();
                if(!tmp.equals("")){
                    trade=new Trade();
                    String[] tradeInfo=tmp.split(",");
                    trade.setBuyTradeID(Integer.parseInt(tradeInfo[0]));
                    trade.setPetID(Integer.parseInt(tradeInfo[1]));
                    trade.setPrice(Integer.parseInt(tradeInfo[2]));
                    trade.setOldMasterID(Integer.parseInt(tradeInfo[3]));
                    trade.setNewMasterID(Integer.parseInt(tradeInfo[4]));
                    trade.setTradeType(Integer.parseInt(tradeInfo[5]));
                    tradeList.add(trade);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tradeList;
    }

    /**
     * 追加写入新交易记录
     * @param tradeInfo
     */
    public static void writeNew(String tradeInfo){
        BufferedWriter bw=null;
        File file=new File(GetFile.TRADE_FILE_NAME);
        bw=IOTools.writer(file);
        try {
            bw.write(tradeInfo);
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
