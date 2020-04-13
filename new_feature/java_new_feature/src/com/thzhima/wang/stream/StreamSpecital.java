package com.thzhima.wang.stream;

import java.util.stream.Stream;

public class StreamSpecital {

	public static void main(String[] args) {
		Stream<Double> stream = Stream.generate(Math::random)
				.limit(10);
		stream.forEach(System.out::println);
		
	}
}
