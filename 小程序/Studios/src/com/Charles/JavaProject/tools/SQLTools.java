package com.Charles.JavaProject.tools;

/**
 * Created by Charles on 2017/7/2.
 */
public class SQLTools {
    public static final String SELECT_ACCOUNT="select * from account";
    public static final String SELECT_CINEMA="select * from cinema";
    public static final String SELECT_FILMS="select * from films";
    public static final String SELECT_SCHEDULE="select * from schedule";
    public static final String SELECT_DAYS="select * from days";
    public static final String SELECT_TIMES="select * from times";
    public static final String SELECT_SEATS="select * from seats";
    public static final String SELECT_VIDEOHALL="select * from videohall";
    public static final String INSERT_FILMS="insert into films(filmID,filmName,filmPrice)values(?,?,?)";
    public static final String INSERT_ACCOUNT="insert into account(accountID,accountName,accountPwd,accountType,accountBalance) values(?,?,?,?,?)";
    public static final String INSERT_CINEMA="insert into account(cinemaID,cinemaName,cinemaAddress,cinemaMoney) values(?,?,?,?)";

}
