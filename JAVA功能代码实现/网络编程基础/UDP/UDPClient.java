package com.Charles.test02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args) throws Exception {
		DatagramSocket socket=new DatagramSocket(200);
		
		String str="charles �����ʺ�";
		DatagramPacket sendPacket=new DatagramPacket(str.getBytes(),str.length(),InetAddress.getByName("127.0.0.1"),5000);
		socket.send(sendPacket);
		System.out.println("�ͻ��˷������ݣ�"+str);
	}

}
