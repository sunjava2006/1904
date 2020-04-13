package com.wangrui.stream;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

public class CreateStream {

	public static void main(String[] args) {
		
		//1 Collection接口方法stream()
		Collection<Integer> coll = Arrays.asList(10,20,30,40,50,15,25,35,45);
		Stream<Integer> stream = coll.stream();
		
		
		//2  数组工具类.stream()
		Stream<String> stream2 = Arrays.stream(new String[]{"Peter", "Will", "Marry", "Smith", "Jack", "John"});
		
		
		//3 Stream.of()方法
		Stream<String> stream3 = Stream.of("China", "Canada", "England", "Russina", "Franch", "Japan");
		
		//4   创建无限流
		// 迭代		
		Stream<Integer> stream4 = Stream.iterate(1, (i) -> i*2);
		stream4.limit(3).forEach(System.out::println);
		 
		// 生成
		Stream<Double> stream5 = Stream.generate(Math::random);
		stream5.limit(2).forEach(System.out::println);
	}
}
