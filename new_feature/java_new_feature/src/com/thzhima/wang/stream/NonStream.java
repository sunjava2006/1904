package com.thzhima.wang.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class NonStream {

	public static void main(String[] args) {
		List<People> list = Arrays.asList(new People("Jack", "Male", 20),
				                          new People("Jack", "Male", 20),
				                          new People("John", "Male", 22),
				                          new People("Tom", "Male", 19),
				                          new People("Smith", "Male", 21),
				                          new People("Marry", "Female", 20),
				                          new People("Rose", "Female", 21));
		
		
//		List<People> people20 = new ArrayList<>();
//		list.forEach(i -> {if(i.getAge()==20)
//			               people20.add(i);
//		             }) ;
//		
//		System.out.println(people20);
//		
//		people20.sort((a,b)->b.getName().compareTo(a.getName()));
//		
//		System.out.println(people20);
//		
//		//=================================================================
//		List<People> li = list.stream().filter(i->i.getAge()==20).sorted((a,b)->b.getName().compareTo(a.getName())).collect(Collectors.toList());
//		System.out.println(li);
		
		
		Stream s = list.stream().filter(i -> {System.out.println("---"+i);return i.getAge()==20;});
		System.out.println("------------- after filter -------------------");
		long count = s.count();
		System.out.println(count);
		
	}
}
