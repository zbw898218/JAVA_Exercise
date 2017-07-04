package com.Charles.test01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPService {

	public static void main(String[] args) throws Exception {
		ServerSocket server=new ServerSocket(4700);
		
		System.out.println("服务器启动成功！");
		
		Socket socket=null;
		while(true){
			socket=server.accept();
			new Thread(new MyThread(socket)).start();
		}
			
			
		
	}

}
