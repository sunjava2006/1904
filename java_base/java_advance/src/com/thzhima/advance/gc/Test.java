package com.thzhima.advance.gc;

import java.util.ArrayList;

public class Test {
    byte[] a = new byte[1024*1024];
	public static void main(String[] args) throws InterruptedException {
		ArrayList<Test> list = new ArrayList<>();
		while(true) {
			list.add(new Test());
			Thread.sleep(10);
		}
		
	}
}
