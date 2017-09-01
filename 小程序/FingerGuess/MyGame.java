package FingerGuess;

import java.util.Scanner;

public class MyGame {

	public static void main(String[] args) {
		FingerGuessall fg=new FingerGuessall();
		String[] cau= {"布","拳","刀"};
		String pp = null;
		int count=0;
		Scanner input =new Scanner(System.in);
		while(count<3){
			
			System.out.println("请选择[布/拳/刀]：");
			pp=input.next();
			if(!fg.inputP(pp)){
				System.out.println("选择错误！");
				count+=1;
			}else{
				int cc=((int)(Math.random()*10)%3+1);//随机生成1到3的整数
				String cc1=fg.CChoose(cc);//电脑选择结果
				String an=fg.guessMethod(pp, cc1);//胜负关系
				fg.printFun(an);//输出胜负关系
				count+=1;//比赛轮次计数
			}
		}
		
		
		
	}

}
