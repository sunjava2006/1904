package com.thzhima.wang.stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Examlation {

	public static void main(String[] args) {
		long count = Stream.of("china").count();
		System.out.println(count);
		
		Stream.of("China", "England", "Russina", "Japan", "Franch").filter(i->i.length()>5).forEach(System.out::println);
		
		
		
		Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20).parallelStream().forEach(i->System.out.println(Thread.currentThread().getName()));
		
		Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20).stream().forEach(i->System.out.println(Thread.currentThread().getName()));
		
	}
}
