package com.wangrui.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorDemo {

	public static void main(String[] args) {
		List<People> list =Arrays.asList(new People("Jack", "Male", 20),
										new People("Jack", "Male", 20),
						                new People("Peger", "Male", 22),
						                new People("Jhon", "Male", 25),
						                new People("Marry", "Female", 19),
						                new People("Rose", "Female", 20),
						                new People("Hellon", "Female", 20));
		
		// 收集到Set中。
		Set<People> peops= list.stream().filter(i -> i.getAge()==20).collect(Collectors.toSet());
		System.out.println(peops);
		
		// 收集到List中。
		List<People> peopList = list.stream().sorted((a,b)->a.getAge()-b.getAge()).collect(Collectors.toList());
		System.out.println(peopList);
		
	}
}
