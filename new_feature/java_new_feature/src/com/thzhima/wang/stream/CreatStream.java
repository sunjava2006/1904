package com.thzhima.wang.stream;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class CreatStream {

	public static void main(String[] args) {
		//1、 Collection
		Collection<Integer> coll = Arrays.asList(10,20,30,40,50);
		Stream<Integer> s1 = coll.stream();
		
		//2、 Arrays
		Stream<Integer> s2 = Arrays.stream(new Integer[]{10, 20, 30, 40,50});
		
		
		//3、 Stream.of
		Stream<Integer> s3 = Stream.of(10,20,30,40,50);
		//s3.forEach(System.out::println);
		
		//4、 Stream 创建无限流
		//4.1 iterate
		Stream<Integer> s4 = Stream.iterate(10, i->i+10).limit(10);
		s4.forEach(System.out::println);
		
		//4.2 generate
		Stream.generate(Math::random).limit(3)
		.forEach(System.out::println);
		
	}

	
}
