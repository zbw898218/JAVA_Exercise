package com.Shop;

import java.util.Map;
import java.util.Scanner;

/*
 * CustomerClass:顾客表
 * 接收顾客根据购买衣服种类和数量以及实付金额，格式化打印输出找零等信息
 */
public class CustomerClass {
	static CustomerClass cst=new CustomerClass();
	static StaffClass stc=new StaffClass();
	static ShopClass sc=new ShopClass();
	static Scanner input=new Scanner(System.in);
	private int num=0;//购买数量
	private String id=null;//购买商品编号
	
//	提供get,set方法设置或得到顾客购买商品的编号和数量
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
	public static void main(String[] args) {
		
		
		stc.setFy();
		ShopClass sc=(ShopClass)stc.setShopMap();
		getPrint(sc);
		doShopFun();
		setKey();
		int i=cst.getNum();
		double pri=(double)sc.getShop().get(cst.getId());
		
		
		System.out.println(cst.getId()+"\t"+"¥"+pri+"\t数量\t"+i+
				"合计\t"+"¥"+(i*pri));
		
		
	}
//	提供方法getPrint格式化打印输出商品表或折扣表
	public static void getPrint(ShopClass sc){
		System.out.println("请选择购买的商品编号：\n");
		sc.printMapFun(sc.getShop());
		System.out.println("\n************************************************");
	}
//	接收顾客购买的商品编号和数量，并打印目录
	public static void doShopFun(){
		System.out.print("请输入商品编号:");
		String id=input.next();
		cst.setId(id);
		System.out.print("请输入购买数量:");
		int num=input.nextInt();
		cst.setNum(num);
		System.out.println(cst.getId());
	}
//	setKey方法用于将用户输入的id转换成商品表的key值
	public static void setKey(){
		String key=cst.getId();
		switch(key){
		case "1":key="1.T恤";
			break;
		case "2":key="2.网球鞋";
			break;
		case "3":key="3.网球拍";
			break;
		case "4":key="4.登山鞋";
			break;
		default:key="1.T恤";
			break;
		}
		cst.setId(key);

	}
}
