package com.Shop;
/*
 * SettleMentClass:结算类
 * 需要调用商品类的shop表和折扣类的point表
 */
public class SettleMentClass {
	private ShopClass sc;
	private TradeClass tc;//声明商品表和交易表
	private double money;//money接收顾客实际付款
	private int num;//num接收顾客购买数量
	private double balance;//balance :给顾客的找零

	//	构造函数,实例化商品表和交易表对象
	public SettleMentClass(){
		this.sc=new ShopClass();
		this.tc=new TradeClass();
	}
//	提供get方法获得商品表和交易表对象
	public ShopClass getSc() {
		return sc;
	}
	
	public TradeClass getTc() {
		return tc;
	}
	
//	提供get和set方法获取顾客的购买数量和实际付款金额
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
//	提供get和set方法算出给顾客的找零
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance,double money) {
		this.balance = balance-money;
	}

}
