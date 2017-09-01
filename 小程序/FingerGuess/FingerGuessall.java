package FingerGuess;

import java.sql.Array;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
public class FingerGuessall implements GuessInterFace{
	String[] cause= {"布","拳","刀"};
	
//	该方法用于判定玩家输入是否合法：true 合法 false 非法
	public boolean inputP(String pc){
		List<String> list=Arrays.asList(cause);
		if(list.contains(pc)){
			return true;
		}else{
			return false;
		}
			
	} 
	
//	通过随机产生1-3的数字代表电脑的出拳结果
	/*
	 * 1：代表电脑出布；
	 * 2：代表电脑出拳；
	 * 3：代表电脑出刀；
	 * @see FingerGuess.GuessInterFace#CChoose(int)
	 */
	public String CChoose(int i){
		if(i==1){
			return "布";
		}else if(i==2){
			return "拳";
		}else{
			return "刀";
		}
		
	}
	
//	输出方法：根据判断结果输出胜负关系
	public void printFun(String an){
		if(an.equals("A")){
			System.out.println("平局！");
		}else if(an.equals("B")){
			System.out.println("玩家胜！");
		}else{
			System.out.println("电脑胜！");
		}
	}
	
//	根据玩家和电脑的选择结果，进行判定，输出胜负关系
	/*
	 * return A：代表平局
	 * return B：代表玩家胜
	 * return C：代表电脑胜
	 * @see FingerGuess.GuessInterFace#guessMethod(java.lang.String, java.lang.String)
	 */
	public String guessMethod(String pc, String cc) {
		if(pc.equals(cc)){
			
			return "A";
		}else if(pc.equals(cause[0])){
			if(cc.equals(cause[1])){
				
				return "B";
			}else{
				
				return "C";
			}
		}else if(pc.equals(cause[1])){
			if(cc.equals(cause[2])){
				return "B";
			}else{
				return "C";
			} 
		}else {
			if(cc.equals(cause[0])){
				return "B";
			}else{
				return "C";
			}
		}
		
	}

}
