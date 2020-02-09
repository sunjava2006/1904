package com.thzhima.base;

public class StringTest {

	static int count = 100000;

	public static void a() {

		String s = "";
		long start = System.currentTimeMillis();

		for (int i = 0; i <= count; i++) {
			s = s + i;
		}

		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}

	public static void b() {

		StringBuffer sb = new StringBuffer();
		long start = System.currentTimeMillis();

		for (int i = 0; i <= count; i++) {
			sb.append(i);
		}

		long end = System.currentTimeMillis();
		System.out.println(end - start);

	}
	
	public static void main(String[] args) {
		a();
		b();
	}
}
