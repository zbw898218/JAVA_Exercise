package FingerGuess;
/*
 * 该接口，主要定义人机猜拳所需的变量
 * String pc：记录人的选择
 * String cc：记录 机的选择
 * boolean count[3]：记录胜负关系的bo数组，3局两胜
 */
public interface GuessInterFace {
	public String guessMethod(String pc,String cc);
	public String CChoose(int i);
	public void printFun(String an);
	public boolean inputP(String pc);
}
