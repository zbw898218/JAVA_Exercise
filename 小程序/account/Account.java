package com.chinasofti.account;
/*
 * 账户公用父类
 */
public abstract class Account {
	/*
	 * @param:accountId-账户id
	 * @param：pwd-账户密码
	 * @param：balance-账户余额
	 * @param:String[] logInfo-记录日志的数组 
	 * @param：int logIndex-数组计数
	 */
	private String accountId;
	private String pwd;
	private double balance;
	private String[] logInfo=new String[10];
	private int logIndex=0;
	
//	构造方法
	public Account(){
//		设定默认值
		this("1111","123123", 0.0);
	}
//	带参构造方法
	public Account(String accountId,String pwd,double balance){
		this.accountId=accountId;
		this.pwd=pwd;
		this.balance=balance;
	}
	
//	账户属性getter和setter方法
	public String getAccountId() {
		return accountId;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String[] getLogInfo() {
		return logInfo;
	}
	public void setLogInfo(String[] logInfo) {
		this.logInfo = logInfo;
	}
	public int getLogIndex() {
		return logIndex;
	}
	public void setLogIndex(int logIndex) {
		this.logIndex = logIndex;
	}
	
	
////	设定抽象方法存款，具体实现交给子类完成
	public abstract void deposit(double i);
////  设定抽象方法取款
//	public abstract void withDraw();
	
}