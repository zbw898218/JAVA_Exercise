package com.Charles1;

public class Person {
	String name;
	String sex;
	boolean flg=false;
	
	public synchronized void set(String name,String sex){
		if(flg){//生成好产品，进入等待
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		产品被买走。生产者继续生产		
		this.name=name;
		this.sex=sex;
		System.out.println("生产产品:"+name+" "+sex);
//		通知消费者购买产品
		flg=true;
		notify();
		
	}
	public synchronized void get(){
		if(!flg){//没有产品时候，等待
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		有产品，被唤醒购买产品，同时唤醒生产者继续sh
		System.out.println("购买产品："+name+" "+sex);
		flg=false;
		notify();
	}
}
