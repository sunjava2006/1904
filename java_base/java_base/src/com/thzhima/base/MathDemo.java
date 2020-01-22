package com.thzhima.base;

import java.util.Random;

public class MathDemo {

	public static void main(String[] args) {
		double ran = Math.random();
//		int max = Math.max(1, 4);
//		System.out.println(Math.pow(2, 3));
		System.out.println(ran);
		
		Random r = new Random();
		for(int i=0;i<10;i++) {
			int v = r.nextInt();
			System.out.println(v);
		}
		
	}
}
