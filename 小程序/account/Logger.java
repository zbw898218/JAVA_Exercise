package com.chinasofti.account;

import java.util.Date;

public class Logger {

//	记录日志的方法。将父类引用account作为参数
//	父类引用指向子类方法-多态 
//	String msg--日志记录
	public static void log(Account account,String msg){
//		通过父类引用获得记录日志的数组和下标
		String[] logInfo=account.getLogInfo();
		int logIndex=account.getLogIndex();
		
//		通过逐条赋值将日志存入数组,日志记录超过10条，从第一条开始覆盖
		if(logIndex>=9){
			logIndex=0;
		}
		
		logInfo[logIndex]=new Date()+" 日志："+msg;
		
//		日志记录完毕后，将日志数组下标传回保存记录
		account.setLogIndex(logIndex);
		account.setLogInfo(logInfo);
	}

//	打印日志的方法
	
	public static void printLog(Account account){
		String[] logInfo=account.getLogInfo();
		for(String s:logInfo){
			if(s!=null){
				System.out.println(s);
			}
		}
	}
}
