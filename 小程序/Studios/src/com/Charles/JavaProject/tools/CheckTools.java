package com.Charles.JavaProject.tools;

import com.Charles.JavaProject.entity.Account;
import com.Charles.JavaProject.entity.Films;
import com.Charles.JavaProject.entity.Seats;
import com.Charles.JavaProject.service.AccountService;
import com.Charles.JavaProject.service.FilmService;

import java.util.Iterator;
import java.util.List;

/**
 *
 *信息校验工具类
 * Created by Charles on 2017/7/2.
 */
public class CheckTools {
    
    public static Seats checkSeats(List<Seats> seatsList,int[] seats){
        Iterator<Seats> it=seatsList.iterator();
        Seats seats1=null;
        while(it.hasNext()){
            Seats tmp=it.next();
            if(tmp.getColumnID()==seats[0]&&tmp.getRowID()==seats[1]){
                if(tmp.getIsSell()==1){
                    System.out.println("抱歉，该座位已经售出！");
                    break;
                }else{
                    seats1=tmp;
                    break;
                }
            }
        }
        return seats1;
    }
    
    public static int getFilmPrice(String filmName) {
        FilmService filmService=new FilmService();
        List<Films> filmsList=filmService.selectFilms();
        Iterator<Films> it=filmsList.iterator();
        while(it.hasNext()){
            Films film=it.next();
            if(film.getFilmName().equals(filmName)){
                return film.getFilmPrice();
            }
        }
        return 0;
    }
    
    /**
     * 获得账户余额
     * @param accountID
     * @return
     */
    public static int getAccountBalance(int accountID) {
        AccountService accountService=new AccountService();
        Account account=accountService.selectAccount(accountID);
        return account.getAccountBalance();
    }
}
