package com.Shop;

import java.util.Scanner;

/*
 * StaffClass:职员类，
 * 职员可通过此类设置商品表和折扣表
 */
public class StaffClass {
	private static String id;
	private static double price;
	private static int num;
	private static double point;
	static Factory fy;
	public static void main(String[] args) {
//		getFy();
	}
	
//	由职员设置商品表和折扣表，并提供getFy方法，返回设定后的细节
	public static void setFy(){
		setShopMap();
		setPointMap();
//		fy.printMapFun(sc.getShop());
//		fy.printMapFun(tc.getPoints());
		
	}
	
	
//	设置商品表
	public static ShopClass setShopMap(){
		fy=new ShopClass();//父类factory引用指向子类商品表
		
		fy.setShop("1.T恤", 245.0);
		fy.setShop("2.网球鞋", 355.0);
		fy.setShop("3.网球拍", 105.0);
		fy.setShop("4.登山鞋", 300.0);
		
		return (ShopClass)fy;
	}
		
//	设置折扣表
	public static TradeClass setPointMap(){
		fy=new TradeClass();
			
		fy.setPoints(1, 0.95);
		fy.setPoints(2, 0.8);
		fy.setPoints(3, 0.75);
		fy.setPoints(4, 0.7);
		return (TradeClass)fy;
	}
		
		
		
		
		
		
		
//		Scanner input = new Scanner(System.in);
//		System.out.print("请输入商品id：");
//		id=input.next();
//		System.out.print("请输入商品id：");
//		price=input.nextDouble();
//		shopc=scc.getSc();//获得商品类对象
//		shopc.setShop(id,price);
	
//	提供方法setPointsMap从控制台输入设置折扣表
//	public static void setPointsMap(){
//		Scanner input = new Scanner(System.in);
//		System.out.print("请输入商品数量：");
//		num=input.nextInt();
//		System.out.print("请输入折扣设置：");
//		point=input.nextDouble();
//		tradec=scc.getTc();//获得商品类对象
//		tradec.setPoints(num,point);
//	}


}
