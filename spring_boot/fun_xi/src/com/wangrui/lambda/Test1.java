package com.wangrui.lambda;

import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.IntConsumer;

public class Test1 {

	public static void main(String[] args) {
		Runnable run = () -> System.out.println("hello");
		
		
		int[] a = new int[]{1,2,3,4,5};
		
		IntConsumer icnsmr =  System.out::println;
		
	
		

		SortedSet<Integer> set = new TreeSet<>(Integer::compare);
		set.add(20);
		set.add(10);
		set.add(30);
		set.forEach(System.out::println);
   
	}
}
