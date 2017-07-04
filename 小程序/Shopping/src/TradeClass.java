package com.Shop;

import java.util.HashMap;
import java.util.Map;
/*
 * TradeClass:points表存储购买数量对应折扣点数
 * 
 */
public class TradeClass extends Factory {
	private Map<String, String> points=new HashMap<String,String>() ;//声明折扣表
	
//	创建构造方法
	public TradeClass(){}
//	继承接口的getMap方法，实例化折扣表
	public Map getMap(){
		return points;
	}
//	使用getPoints方法存入数量对应折扣点数
	public void setPoints(int num,double point){
		this.getMap().put(num, point);
	}
//	提供getPoints方法以供外部调用points折扣表
	public Map getPoints(){
		return this.points;
	}
//	实现接口格式化打印输出map类型
	
	
}
