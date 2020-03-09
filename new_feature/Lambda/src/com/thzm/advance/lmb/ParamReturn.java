package com.thzm.advance.lmb;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Consumer;

public class ParamReturn {
	
	public static void main(String[] args) {
		
		// Lambda实现接口方法。接口方法：是没有参数，没有返回值。
		// Runnable接口中定义的run()方法,是没有参数，没有返回值的。
		Runnable run = ()->System.out.println(Thread.currentThread().getName());
		Thread t = new Thread(run);
		t.start();
		
		// Lamdba实现接口方法。接口方法：有一个参数，没有返回值。
		// Consumer接口中定义的accept(T t)方法有一个参数，没有返回值。
		Consumer<Integer> consumer = (Integer i) -> System.out.println(i);
		List<Integer> list = Arrays.asList(5,10,15,20,25,30);
		list.forEach(consumer);
		
		// Lamdba实现接口方法。接口有多个参数，有返回值。
		// Comparator接口方法“int compare(T o1, T o2)”，有两个参数，有返回值。
		Comparator<Integer> comparatorAsc = (a, b) -> {return a-b;}; 
		Comparator<Integer> comparatorDesc = (a, b) ->  b-a;
		// SortedSet使用两种不同的比较器。
		SortedSet<Integer> setA = new TreeSet<>(comparatorAsc);
		setA.add(100);
		setA.add(50);
		setA.add(200);
		setA.forEach((i)->System.out.println(i));
		setA = new TreeSet<>(comparatorDesc);
		setA.add(100);
		setA.add(50);
		setA.add(200);
		setA.forEach((i)->System.out.println(i));
		
		
		// 方法体有多条语句
		Consumer<Integer> c = i -> {int a = i*2; 
		                            System.out.println(a); };
		
		// 方法体只有一条语句
		Consumer<Integer> c2 = i -> System.out.println(i*2); 
	}

}
