package com.thzhima.advance.reflact;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflactOperationDemo {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		// 1��������
		String className = "com.thzhima.advance.reflact.People";
		Object o = Class.forName(className).newInstance(); // �ں����ǵ��õ��޲ι���
		People p = (People)o;
		System.out.println(p);
		
		// 1.1ͨ���޲ι��촴������
		Constructor constractor = Class.forName(className).getConstructor();
		Object o2 = constractor.newInstance();
		System.out.println(o2);
		
		// 1.2ͨ���вι��촴������
		Constructor constructor2 = Class.forName(className).getDeclaredConstructor(String.class, int.class);
		People p2 = (People) constructor2.newInstance("Wang", 30);
		System.out.println(p2);
		
		
		
		// ��ȡ���ԣ�ȡ����ֵ
		
		Class peopleClass =  Class.forName(className);
		Field nameField = peopleClass.getDeclaredField("name");
		if(nameField.isAccessible()) { // �ж��ֶ��Ƿ�ɷ���
			System.out.println("��������");
			nameField.set(p, "����");
		}else {
			nameField.setAccessible(true);
			nameField.set(p, "����");
		}
		
		Field ageField = peopleClass.getDeclaredField("age");
		if(ageField.isAccessible()) {
			ageField.set(p, 20);
		}else {
//			Method setAgeMethod = peopleClass.getMethod("setAge", int.class);
//			setAgeMethod.invoke(p, 20); // ���÷���
			
			ageField.setAccessible(true); // �ò��ܷ��ʵ��ֶΣ���Ϊ�ɷ��ʵġ�
			ageField.set(p, 80); 
		}
		
		System.out.println(ageField.get(p));// ȡ�ֶ� ֵ
		
		
		
		// ��ȡ���������÷���
		Method m = peopleClass.getMethod("work");
		m.invoke(p);
		
		Annotation[] ans = m.getDeclaredAnnotations();
		for(Annotation a:ans) {
			System.out.println(a);
		}
		
		
		
		Method m2 = peopleClass.getMethod("work", String.class);
		m2.invoke(p, "��ɨ");

		ans = peopleClass.getDeclaredAnnotations();
		for(Annotation a:ans) {
			System.out.println(a);
		}
		
		int i = Integer.MAX_VALUE+1;
		System.out.println(Integer.MAX_VALUE>i);
	}

}
