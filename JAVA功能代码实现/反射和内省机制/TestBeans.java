package com.Charles.test03;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

public class TestBeans {
/**
 * ����java��ʡ����
 * @param args
 */
	public static void main(String[] args) {
		try {
			BeanInfo perInfo=Introspector.getBeanInfo(Person.class);
			PropertyDescriptor[] pers=perInfo.getPropertyDescriptors();
			for(PropertyDescriptor per:pers){
				System.out.println(per.getName());
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
