package com.chinasofti.account;

public class CreditAccount extends Account {

	public void deposit(double money){
		super.setBalance(super.getBalance()+money);
		Logger.log(this, "存入金额："+money);
	}

}
