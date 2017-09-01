package com.Charles1;

public class Procuder implements Runnable{
	Person p;
	public Procuder(Person p){
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
				if(i%2==0){
					p.set("aa","男");
				}else{
					p.set("bb","女");
				}
				
				
			}
		
		}

}
