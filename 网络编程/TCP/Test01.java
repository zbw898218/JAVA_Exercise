package com.Charles.test01;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Test01 {

	public static void main(String[] args) {
		try {
			InetAddress add1=InetAddress.getLocalHost();
			InetAddress add2=InetAddress.getByName("USER-20170428BK");
			InetAddress add3=InetAddress.getByName("www.github.com");
			InetAddress add4=InetAddress.getByName("192.168.2.96");
			
//			String name=add2.getHostName();
			String nam1=add4.getHostName();
			System.out.println(add1.toString());
			System.out.println(add2);
			System.out.println(add3);
			System.out.println(add4);
//			System.out.println(name);
			System.out.println(nam1.toString());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
