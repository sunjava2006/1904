package com.wangrui.stream;

import java.util.Arrays;
import java.util.List;

public class FlatMapOp {

	public static void main(String[] args) {
		List<Integer> lista = Arrays.asList(10,20,30);
		List<Integer> listb = Arrays.asList(40,50,60);
		List<Integer> listc = Arrays.asList(70,80,90);
		
		List<List<Integer>> list = Arrays.asList(lista, listb, listc);
		
		// 不使用flatMap，我们看到的是在Stream中包含3个List。
		list.stream().forEach(System.out::println);
		
		// 使用map,将每一个List中元素放到一个Stream中.
		list.stream().map((a)->a.stream()).forEach(System.out::println);
		
		// 使用flatMap,将每一个List中元素放到一个Stream中，并合并到一个大的Stream中。
		list.stream().flatMap((a)->a.stream()).forEach(System.out::println);
		
		
	}
}
