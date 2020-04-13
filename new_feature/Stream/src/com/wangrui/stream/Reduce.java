package com.wangrui.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		Integer sum = list.stream().reduce(0, (a,b)->a+b);
		System.out.println(sum);
		
		
		Optional opSum = list.stream().reduce((a,b)->a+b);
		System.out.println(opSum.isPresent()? opSum.get(): "Ã»ÓÐÖµ");
		
	}
}
