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
			//ͨ��Class.forName(����+����)�����Class�����
			Class cls1=Class.forName(cls.getName());
			//ͨ����õ�Class����ֱ�Ӵ���Ŀ�������
			Person p=(Person)cls1.newInstance();
			
			Constructor con=cls1.getConstructor(String.class,Integer.class);
			
			Person p1=(Person) con.newInstance("����",10);
			System.out.println(p1);
			//��ù��췽������
			Constructor<Person>[] cons=cls1.getConstructors();
			//�����������
			Field[] fields=cls1.getDeclaredFields();
			//��÷�������
			Method[] methods=cls1.getDeclaredMethods();
			
			
			System.out.println(Arrays.toString(cons));
			System.out.println(Arrays.toString(fields));
			System.out.println(Arrays.toString(methods));
			Class[] per=cls1.getClasses();
			System.out.println(Arrays.toString(per));
			System.out.println("--------------------------");
			//����field.get/set������������ֵ
			ps=(Person) cls1.newInstance();
			Field names=null,age=null,sex=null;
			for(int i=0;i<fields.length;i++){
				//����Ȩ�� ���ÿɽ���ɷ���Ϊ��true
				fields[i].setAccessible(true);
				if(fields[i].getName().equals("name")){
					
					fields[i].set(ps, "Black");
					names=fields[i];
				}else if(fields[i].getName().equals("age")){
					
					fields[i].setInt(ps, 55);
					age=fields[i];
				}else if(fields[i].getName().equals("sex")){
					
					fields[i].set(ps, "Ů");
					sex=fields[i];
				}
			}
			System.out.println(ps);
			
			System.out.println(names.get(ps)+" "+age.getInt(ps)+" "+sex.get(ps));
			
			
			
			
			
			
			
			
			System.out.println("--------------------------");
			//����method.invoke����
			String name=methods[2].getName();
			System.out.println(methods[2].getParameterCount());
			System.out.println(methods[4]);
			for(int i=0;i<methods.length;i++){
				if(methods[i].getName().equals("setName")){
					methods[i].invoke(p, "����");
				}else if(methods[i].getName().equals("setAge")){
					methods[i].invoke(p, 20);
				}else if(methods[i].getName().equals("setSex")){
					methods[i].invoke(p, "��");
				}
			}
			
			System.out.println(Arrays.toString(methods[2].getParameters()));
			System.out.println(p);
			System.out.println("-------------");
			//ͨ����õĹ��췽��ʵ��������
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
