package com.thzhima.wang.lambda;

import java.util.Random;
import java.util.stream.Stream;

public class ConstructorRef {

	public static void main(String[] args) {
		Stream.generate(()-> new Random()).limit(10).forEach(i->System.out.println(i));
	}
}
