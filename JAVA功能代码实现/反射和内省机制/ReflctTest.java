package com.Charles.test03;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class ReflctTest {

	public static void main(String[] args) {
		Class cls=Person.class;
		System.out.println(cls.getName());
		
		try {
			Person ps=null;
			//通过Class.forName(包名+类名)，获得Class类对象
			Class cls1=Class.forName(cls.getName());
			//通过获得的Class对象，直接创建目标类对象
			Person p=(Person)cls1.newInstance();
			
			Constructor con=cls1.getConstructor(String.class,Integer.class);
			
			Person p1=(Person) con.newInstance("张三",10);
			System.out.println(p1);
			//获得构造方法数组
			Constructor<Person>[] cons=cls1.getConstructors();
			//获得属性数组
			Field[] fields=cls1.getDeclaredFields();
			//获得方法数组
			Method[] methods=cls1.getDeclaredMethods();
			
			
			System.out.println(Arrays.toString(cons));
			System.out.println(Arrays.toString(fields));
			System.out.println(Arrays.toString(methods));
			Class[] per=cls1.getClasses();
			System.out.println(Arrays.toString(per));
			System.out.println("--------------------------");
			//调用field.get/set方法设置属性值
			ps=(Person) cls1.newInstance();
			Field names=null,age=null,sex=null;
			for(int i=0;i<fields.length;i++){
				//设置权限 设置可进入可访问为：true
				fields[i].setAccessible(true);
				if(fields[i].getName().equals("name")){
					
					fields[i].set(ps, "Black");
					names=fields[i];
				}else if(fields[i].getName().equals("age")){
					
					fields[i].setInt(ps, 55);
					age=fields[i];
				}else if(fields[i].getName().equals("sex")){
					
					fields[i].set(ps, "女");
					sex=fields[i];
				}
			}
			System.out.println(ps);
			
			System.out.println(names.get(ps)+" "+age.getInt(ps)+" "+sex.get(ps));
			
			
			
			
			
			
			
			
			System.out.println("--------------------------");
			//调用method.invoke方法
			String name=methods[2].getName();
			System.out.println(methods[2].getParameterCount());
			System.out.println(methods[4]);
			for(int i=0;i<methods.length;i++){
				if(methods[i].getName().equals("setName")){
					methods[i].invoke(p, "张三");
				}else if(methods[i].getName().equals("setAge")){
					methods[i].invoke(p, 20);
				}else if(methods[i].getName().equals("setSex")){
					methods[i].invoke(p, "男");
				}
			}
			
			System.out.println(Arrays.toString(methods[2].getParameters()));
			System.out.println(p);
			System.out.println("-------------");
			//通过获得的构造方法实例化对象
			ps=cons[0].newInstance("jack",20);
			System.out.println(ps);
			ps=cons[1].newInstance(null);
			System.out.println(ps);
			ps=cons[2].newInstance("tom",21,"nv");
			System.out.println(ps);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
