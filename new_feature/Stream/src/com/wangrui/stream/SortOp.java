package com.wangrui.stream;

import java.util.Arrays;
import java.util.List;

public class SortOp {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10,30,20,50,60,40);
		
		list.stream().sorted() //��Ȼ����
		.forEach(System.out::println);
		
		list.stream().sorted((a,b)-> b-a) // ǿ������
		.forEach(System.out::println);
	}
}
