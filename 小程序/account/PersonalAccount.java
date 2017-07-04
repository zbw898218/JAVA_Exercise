package com.chinasofti.account;

public class PersonalAccount extends Account {
	
//	存钱，活期
	public void deposit(double money){
		super.setBalance(super.getBalance()+money);
		Logger.log(this, "存入金额："+money);
	}
	
	
	

	

}
