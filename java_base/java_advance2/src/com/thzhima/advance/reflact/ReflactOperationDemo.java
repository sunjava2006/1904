package com.thzhima.advance.reflact;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflactOperationDemo {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		// 1创建对象
		String className = "com.thzhima.advance.reflact.People";
		Object o = Class.forName(className).newInstance(); // 在后面是调用的无参构造
		People p = (People)o;
		System.out.println(p);
		
		// 1.1通过无参构造创建对象
		Constructor constractor = Class.forName(className).getConstructor();
		Object o2 = constractor.newInstance();
		System.out.println(o2);
		
		// 1.2通过有参构造创建对象
		Constructor constructor2 = Class.forName(className).getDeclaredConstructor(String.class, int.class);
		People p2 = (People) constructor2.newInstance("Wang", 30);
		System.out.println(p2);
		
		
		
		// 获取属性，取、赋值
		
		Class peopleClass =  Class.forName(className);
		Field nameField = peopleClass.getDeclaredField("name");
		if(nameField.isAccessible()) { // 判断字段是否可访问
			System.out.println("设置名字");
			nameField.set(p, "林益");
		}else {
			nameField.setAccessible(true);
			nameField.set(p, "林益");
		}
		
		Field ageField = peopleClass.getDeclaredField("age");
		if(ageField.isAccessible()) {
			ageField.set(p, 20);
		}else {
//			Method setAgeMethod = peopleClass.getMethod("setAge", int.class);
//			setAgeMethod.invoke(p, 20); // 调用方法
			
			ageField.setAccessible(true); // 让不能访问的字段，变为可访问的。
			ageField.set(p, 80); 
		}
		
		System.out.println(ageField.get(p));// 取字段 值
		
		
		
		// 获取方法，调用方法
		Method m = peopleClass.getMethod("work");
		m.invoke(p);
		
		Annotation[] ans = m.getDeclaredAnnotations();
		for(Annotation a:ans) {
			System.out.println(a);
		}
		
		
		
		Method m2 = peopleClass.getMethod("work", String.class);
		m2.invoke(p, "打扫");

		ans = peopleClass.getDeclaredAnnotations();
		for(Annotation a:ans) {
			System.out.println(a);
		}
		
		int i = Integer.MAX_VALUE+1;
		System.out.println(Integer.MAX_VALUE>i);
	}

}
