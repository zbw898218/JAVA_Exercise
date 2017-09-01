package com.Charles.test02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) throws Exception{
		DatagramSocket seceiveSocket=new DatagramSocket(5000);
		byte[] bytes=new byte[1024];
		DatagramPacket seceivePacket=new DatagramPacket(bytes, bytes.length);
		System.out.println("服务器启动成功");
		while(true){
			seceiveSocket.receive(seceivePacket);
			System.out.println("主机信息："+seceivePacket.getAddress());
			System.out.println("接收数据："+new String(seceivePacket.getData(),0,seceivePacket.getLength()));
		}
		
	}

}
