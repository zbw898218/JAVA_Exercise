package com.Charles.DeminGame;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
/*
 * Author:Charles
 * Rules:用于生成扫雷真假值数组
 */
public class Rules {
	private static Rules rule=new Rules();
	private Rules(){
	}
	public static Rules getRules(){
		return rule;
	}
	public int[] gameData() {
		int[] arr=new int[100];
		int[] bo=new int[30];
//		生成一个元素0-100之间随机数的30长度数组。数组的每个元素代表地雷所在的按钮的编号
		HashSet<Integer> set=new HashSet<Integer>();
//		使用HashSet去重存储随机数，并转存入bo数组中
		boolean flg=true;
		while(flg){
			int sum=(int)(Math.random()*100);
			set.add(sum);
			if(set.size()==30){
				flg=false;
			}
		}
		int m=0; 
		for(Integer a:set){
			bo[m]=a;
			m++;
		}
		
//		生成一个编号从0-99的按钮编号数组
		for(int i=0;i<100;i++){
			arr[i]=i;
		}
//		根据bo数组。将对应arr数组对应元素值替换成-1
		Arrays.sort(bo);
		for(int i:bo){
			System.out.print(i+" ");
			arr[i]=-1;
		}
		System.out.println("\n");
		System.out.println("----------------------------");
		for(int i:arr){
			System.out.print(i+" ");
		}
		System.out.println("\n");
		System.out.println("----------------------------");
//		根据规律，计算每个不是-1的元素周围有几个-1.将值赋给当前元素
		for(int i=0;i<100;i++){
			int count=0;
			int n2=i-10,n7=i+10,n4=i-1,
				n5=i+1,n1=i-11,n3=i-9,n8=i+11,n6=i+9;
//			特殊处理4条边和4个顶点
			if(arr[i]!=-1){
			if(i==0){
				
				if(arr[n5]==-1){
					count+=1;
				}
				if(arr[n7]==-1){
					count+=1;
				}
				if(arr[n8]==-1){
					count+=1;
				}
				if(count!=0){
				arr[i]=count;
				
				}else{
					arr[i]=0;
				}
				count=0;
			}else if(i>0&&i<9){
				if(arr[n4]==-1){
					count+=1;
				}
				if(arr[n5]==-1){
					count+=1;
				}
				if(arr[n6]==-1){
					count+=1;
				}
				if(arr[n7]==-1){
					count+=1;
				}
				if(arr[n8]==-1){
					count+=1;
				}
				
				if(count!=0){
					arr[i]=count;
				}else{
					arr[i]=0;
					}
					count=0;
			}else if(i==9){
				if(arr[n4]==-1){
					count+=1;
				}
				if(arr[n6]==-1){
					count+=1;
				}
				if(arr[n7]==-1){
					count+=1;
				}
				if(count!=0){
					arr[i]=count;
				}else{
					arr[i]=0;
					}
					count=0;
			}
			else if(i==10||i==20||i==30||i==40||i==50||i==60||i==70||i==80){
				if(arr[n2]==-1){
					count+=1;
				}
				if(arr[n3]==-1){
					count+=1;
				}
				if(arr[n5]==-1){
					count+=1;
				}
				if(arr[n7]==-1){
					count+=1;
				}
				if(arr[n8]==-1){
					count+=1;
				}
				if(count!=0){
					arr[i]=count;
				}else{
					arr[i]=0;
					}
					count=0;
			}
			
			else if(i==19||i==29||i==39||i==49||i==59||i==69||i==79||i==89){
				if(arr[n1]==-1){
					count+=1;
				}
				if(arr[n2]==-1){
					count+=1;
				}
				if(arr[n4]==-1){
					count+=1;
				}
				if(arr[n7]==-1){
					count+=1;
				}
				if(arr[n6]==-1){
					count+=1;
				}
				if(count!=0){
					arr[i]=count;
				}else{
					arr[i]=0;
					}
					count=0;
			}
			
			else if(i==90){
				if(arr[n2]==-1){
					count+=1;
				}
				if(arr[n3]==-1){
					count+=1;
				}
				if(arr[n5]==-1){
					count+=1;
				}
				if(count!=0){
					arr[i]=count;
				}else{
					arr[i]=0;
					}
					count=0;
			}
			else if(i>90&&i<99){
				if(arr[n1]==-1){
					count+=1;
				}
				if(arr[n2]==-1){
					count+=1;
				}
				if(arr[n3]==-1){
					count+=1;
				}
				if(arr[n4]==-1){
					count+=1;
				}
				if(arr[n5]==-1){
					count+=1;
				}
				if(count!=0){
					arr[i]=count;
				}else{
					arr[i]=0;
					}
					count=0;
			}
			else if(i==99){
				if(arr[n1]==-1){
					count+=1;
				}
				if(arr[n2]==-1){
					count+=1;
				}
				if(arr[n4]==-1){
					count+=1;
				}
				if(count!=0){
					arr[i]=count;
				}else{
					arr[i]=0;
					}
					count=0;
			}else{
				if(arr[n1]==-1){
					count+=1;
				}
				if(arr[n2]==-1){
					count+=1;
				}
				if(arr[n3]==-1){
					count+=1;
				}
				if(arr[n4]==-1){
					count+=1;
				}
				if(arr[n5]==-1){
					count+=1;
				}
				if(arr[n6]==-1){
					count+=1;
				}
				if(arr[n7]==-1){
					count+=1;
				}
				if(arr[n8]==-1){
					count+=1;
				}
				if(count!=0){
					arr[i]=count;
				}else{
					arr[i]=0;
					}
					count=0;
			}
			}
			}
		for(int i:arr){
			System.out.print(i+" ");
		}
			
		return arr;
	}

}
