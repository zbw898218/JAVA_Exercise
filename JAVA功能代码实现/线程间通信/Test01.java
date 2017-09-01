package com.Charles1;

public class Test01 {
	public static void main(String[] args) {
		Person p=new Person();
		Thread t1=new Thread(new Procuder(p));
		Thread t2=new Thread(new Customer(p));
		t1.start();
		t2.start();
	}
}
