package com.thzhima.wang.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MethodRef {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("China","England","Russina", "Japan");
		list.forEach(System.out::println);// 方法引用
		
		Stream.generate(Math::random).limit(10).forEach(System.out::println);
		
		A a = String::substring;
		String s = a.sub("HelloWorld", 0, 5);
		System.out.println(s);
		
	}
}
interface A{
	String sub(String source, int start, int end);
}