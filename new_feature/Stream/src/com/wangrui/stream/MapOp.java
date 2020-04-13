package com.wangrui.stream;

import java.util.Arrays;
import java.util.List;

public class MapOp {

	public static void main(String[] args) {
		List<People> list =Arrays.asList(new People("Jack", "Male", 20),
				 new People("Jack", "Male", 20),
                new People("Peger", "Male", 22),
                new People("Jhon", "Male", 25),
                new People("Marry", "Female", 19),
                new People("Rose", "Female", 20),
                new People("Hellon", "Female", 20));
		
		//==================== map ============================
		// 返回People的名字
		list.stream().map(a->a.getName()) 
		             .forEach(System.out::println);
		
		
		// 每一个元素返回1，可以用来计数
		long count = list.stream().map(a -> 1) 
				                  .count();
		System.out.println(count);
		

		
		
		
		
		
	}
}
