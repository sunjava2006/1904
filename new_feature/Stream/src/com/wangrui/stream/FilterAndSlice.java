package com.wangrui.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FilterAndSlice {

	
	
	public static void main(String[] args) {
		
		List<People> list =Arrays.asList(new People("Jack", "Male", 20),
										 new People("Jack", "Male", 20),
				                         new People("Peger", "Male", 22),
				                         new People("Jhon", "Male", 25),
				                         new People("Marry", "Female", 19),
				                         new People("Rose", "Female", 20),
				                         new People("Hellon", "Female", 20));
		
//		Stream s = list.stream().filter((i)->{System.out.println("filter:"+i);return "Female".equals(i.getGender());}) //�������filter����ִ��ʱ��������
//		                        .sorted((a,b)->a.getAge()-b.getAge())
//		                        .map((e)-> {System.out.println("map:"+e);return e.getName();});//�������map����ִ��ʱ��������
//		
//		System.out.println("-------------before count--------------");
//		long count = s.count();
//		
//		System.out.println(count);
		
		//=================================filter  ɸѡ������J��ͷ����=======================
		
//		Stream<People> stream = list.stream().filter((i) -> i.getName().startsWith("J"));
//		
//		stream.forEach(System.out::println);
//		
		
		//================================= limit ����Ԫ�ص�����===================================
//		list.stream().filter((i)->{System.out.println("������" + i); 
//		                           return i.getAge()>19;})
//		             .limit(2)
//		             .forEach(System.out::println);
		
		//================================== skip =================================
//		list.stream().skip(1).filter(i->i.getName().startsWith("J"))
//		.forEach(System.out::println);
//		
		//--------------------------------------------------------------------------
		list.stream().distinct().forEach(System.out::println);
		
	}
}
