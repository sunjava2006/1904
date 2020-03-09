package com.thzm.advance.lmb;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Consumer;

public class ParamReturn {
	
	public static void main(String[] args) {
		
		// Lambdaʵ�ֽӿڷ������ӿڷ�������û�в�����û�з���ֵ��
		// Runnable�ӿ��ж����run()����,��û�в�����û�з���ֵ�ġ�
		Runnable run = ()->System.out.println(Thread.currentThread().getName());
		Thread t = new Thread(run);
		t.start();
		
		// Lamdbaʵ�ֽӿڷ������ӿڷ�������һ��������û�з���ֵ��
		// Consumer�ӿ��ж����accept(T t)������һ��������û�з���ֵ��
		Consumer<Integer> consumer = (Integer i) -> System.out.println(i);
		List<Integer> list = Arrays.asList(5,10,15,20,25,30);
		list.forEach(consumer);
		
		// Lamdbaʵ�ֽӿڷ������ӿ��ж���������з���ֵ��
		// Comparator�ӿڷ�����int compare(T o1, T o2)�����������������з���ֵ��
		Comparator<Integer> comparatorAsc = (a, b) -> {return a-b;}; 
		Comparator<Integer> comparatorDesc = (a, b) ->  b-a;
		// SortedSetʹ�����ֲ�ͬ�ıȽ�����
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
		
		
		// �������ж������
		Consumer<Integer> c = i -> {int a = i*2; 
		                            System.out.println(a); };
		
		// ������ֻ��һ�����
		Consumer<Integer> c2 = i -> System.out.println(i*2); 
	}

}
