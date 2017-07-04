package com.Charles.test01;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class MyThread implements Runnable {
	private Socket socket;
	public MyThread(Socket socket){
		this.socket=socket;
	}
	@Override
	public void run() {
		try {
			DataInputStream is=new DataInputStream(socket.getInputStream());
			DataOutputStream os=new DataOutputStream(socket.getOutputStream());
			BufferedReader sin=new BufferedReader(new InputStreamReader(System.in));
			String line=sin.readLine();
			System.out.println("Client:"+is.readUTF());
			while(!line.equals("exit")){
				os.writeUTF(line);
				os.flush();
				System.out.println("Client:"+is.readUTF());
				line=sin.readLine();
			}
			os.close();
			is.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
