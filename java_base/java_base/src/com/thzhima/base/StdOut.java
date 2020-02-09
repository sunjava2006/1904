package com.thzhima.base;

import java.io.PrintStream;

public class StdOut {

	public static void main(String[] args) {
		PrintStream o = System.out;
		o.append("hello\t");
		
		o.append("world");
		System.out.println();
		o.format("%s world!!", "hello");
	}
}
