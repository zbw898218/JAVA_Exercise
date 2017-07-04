package com.Charles.test01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPClient {

	public static void main(String[] args) throws Exception{
		Socket socket=new Socket("127.0.0.1",4700);
		System.out.println("客户端启动成功！");
		DataInputStream is=new DataInputStream(socket.getInputStream());
		DataOutputStream os=new DataOutputStream(socket.getOutputStream());
		BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Client:");
		String line=sin.readLine();
		while(!line.equals("exit")){
			os.writeUTF(line);
			os.flush();
			System.out.println("Server:"+is.readUTF());
			line=sin.readLine();
		}
		os.close();
		is.close();
		socket.close();
			
	}

}
