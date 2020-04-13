package com.thzhima.wang.stream;

import java.util.Arrays;
import java.util.List;

public class SelectAndSplic {

	public static void main(String[] args) {
		List<People> list = Arrays.asList(  new People("Jack", "Male", 20),
							                new People("Jack", "Male", 20),
							                new People("John", "Male", 22),
							                new People("Tom", "Male", 19),
							                new People("Smith", "Male", 21),
							                new People("Marry", "Female", 20),
							                new People("Rose", "Female", 21));
		
		
		// filter
		list.stream().filter(i->i.getName().startsWith("J")).forEach(System.out::print);
		System.out.println();
		
		// limit
		list.stream().filter(i->{System.out.println("X");return i.getAge()>20;}).limit(2)
		.forEach(i -> System.out.println(i));
		
		
		// skip
		long count = list.stream().skip(6).count();
		System.out.println(count);
		
		
		// distinct
		list.stream().distinct().forEach(i -> System.out.println(i));
		
	}
}
