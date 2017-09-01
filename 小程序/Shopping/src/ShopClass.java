package com.Shop;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShopClass extends Factory{
	private Map shop =new HashMap();//声明shop表
	//	构造函数
	public ShopClass(){};
//	继承接口的getMap方法，实例化shop表
	
	public Map getMap() {
		return shop;
	}
//	通过setShop方法将商品的id和name键值对存入shop表中
	public void setShop(String id,double price){
		this.getMap().put(id, price);
	}
	//提供getShop表以供外部调用
	public Map getShop(){
		return shop;
	}
//	实现接口格式化打印输出map类型
//	public void printShopFun(Map map){
//		Iterator iter=map.entrySet().iterator();//创建迭代器
//		while(iter.hasNext()){
//			Map.Entry entry=(Map.Entry)iter.next();
//			Object key=entry.getKey();
//			Object val=entry.getValue();
//			System.out.println(key+"."+val);
//		}
//	}
}
