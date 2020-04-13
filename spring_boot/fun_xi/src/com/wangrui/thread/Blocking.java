package com.wangrui.thread;

import java.util.concurrent.ArrayBlockingQueue;

public class Blocking {

	public static void main(String[] args) throws InterruptedException {
		ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(4);
		
//		String value = queue.poll();
//		String value = queue.remove();
		queue.put("China");
		queue.put("China");
		queue.put("China");
		queue.put("China");
//		queue.put("China");
		System.out.println(queue.size());
		
		String value = queue.take();
		System.out.println(value);
		
		short s1 = 1; 
		s1 = (short) (s1 + 1);
		
		short s2 = 1; 
		s2 += 1;
	}
}
