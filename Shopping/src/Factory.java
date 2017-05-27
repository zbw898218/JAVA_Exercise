package com.Shop;

import java.util.Iterator;
import java.util.Map;

public  class Factory implements Tools {
	
	public Factory(){}
	public Map getMap() {
		return null;
	}
	public void setShop(String id,double price){}
	public void setPoints(int num,double point){}
	
	public void printMapFun(Map map){
		Iterator iter=map.entrySet().iterator();//创建迭代器
		while(iter.hasNext()){
			Map.Entry entry=(Map.Entry)iter.next();
			Object key=entry.getKey();
			Object val=entry.getValue();
			System.out.print(entry.getKey()+"\t"+entry.getValue()+"\t");
		}
	}
	
}
