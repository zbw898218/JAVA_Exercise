package com.Charles.DeminGame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeminGame extends JFrame {
	private JButton begin,stop,quit;//定义开始，结束，退出按钮
	private JButton[] allButtons;//接受100个按钮作为雷存储
	private JPanel panel,apanel,p1;//定义面板容器容纳按钮，定义主面板容纳扫雷按钮
	private JTextField output;
	public DeminGame(){
		this.setTitle("Charle's DaminGame!");
		this.setSize(400,500);
		
		begin=new JButton("开始");
		stop=new JButton("结束");
		quit=new JButton("退出");
		panel=new JPanel();
		apanel=new JPanel();
		allButtons=new JButton[100];
		output=new JTextField();
		for(int i=0;i<100;i++){
			allButtons[i]=new JButton();
			allButtons[i].setSize(20, 20);
			allButtons[i].setVisible(true);
		}
		
		this.setVisible(true);//设置可见
	}
//	init方法提供初始化扫雷游戏
	public void init(){
//		jframe窗体添加布局容器
		Container contentPane=new Container();
		this.setContentPane(contentPane);
		
		contentPane.setLayout(new BorderLayout());//容器采用方位布局
		contentPane.add(panel, BorderLayout.NORTH);
		contentPane.add(apanel, BorderLayout.CENTER);
		contentPane.add(output, BorderLayout.SOUTH);
		
//		panel容器添加流布局，添加按钮
		panel.setLayout(new FlowLayout());
		panel.add(begin);
		panel.add(stop);
		panel.add(quit);
		
//		apanel容器添加网格布局，添加按钮
		apanel.setLayout(new GridLayout(10,10));
		for(int i=0;i<100;i++){
			apanel.add(allButtons[i]);
		}
		begin.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				output.setText("游戏正式开始！");
				
			}
			
		});
		
		
		stop.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("游戏结束！");
				System.exit(HIDE_ON_CLOSE);
//				DeminGame.this.validate();//调用 外部对象自身用法
				
				}
		});
		quit.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("退出游戏！");
				System.exit(0);
			}
		});
		for(JButton jb:allButtons){
			jb.addActionListener(new MyButtonListener());
		}
	}
	
	class MyButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JButton jb=(JButton)(e.getSource());//获得事件真正源
			jb.setVisible(false);
			for(int i=0;i<100;i++){
				if(jb.equals(allButtons[i])){
					int a=(int)(Math.random()*10);
					if(a>=7){
						output.setText("对不起，你踩中地雷了!Game Over!");
						System.out.println("对不起，你踩中地雷了!Game Over!");
					}else{
						output.setText("安全！");
					}
					System.out.println(a);
				}
			}
		}
	}
	public static void main(String[] args) {
		DeminGame dg=new DeminGame();
		dg.init();
	}

}
