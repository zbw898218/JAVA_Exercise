package com.Charles.test02;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer {
	public static void main(String[] args) throws Exception{
		DatagramSocket seceiveSocket=new DatagramSocket(5000);
		byte[] bytes=new byte[1024];
		DatagramPacket seceivePacket=new DatagramPacket(bytes, bytes.length);
		System.out.println("�����������ɹ�");
		while(true){
			seceiveSocket.receive(seceivePacket);
			System.out.println("������Ϣ��"+seceivePacket.getAddress());
			System.out.println("�������ݣ�"+new String(seceivePacket.getData(),0,seceivePacket.getLength()));
		}
		
	}

}
