package com.chinasofti.account;

public class TestAccount {

	public static void main(String[] args) {
		Account a1=new PersonalAccount();
		Account a2=new CreditAccount();
		
//		System.out.println(a1.getAccountId()+";"+a1.getBalance());

		a1.deposit(100);
//		Logger.printLog(a1);
		a2.deposit(2000);
		Logger.printLog(a2);
	}

}
