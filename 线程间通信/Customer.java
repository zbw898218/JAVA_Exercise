package com.Charles1;

public class Customer implements Runnable {
	Person p;
	
	public Customer() {
		super();
	}
	public Customer(Person p) {
		this.p=p;
	}
	@Override
	public void run() {
		for(int i=0;i<10;i++){
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			p.get();
		}
	}
}
