package com.thzhima.advance.coll;

import java.util.ArrayList;
import java.util.List;

public class ThreadSafeDemo {

	public static void main(String[] args) throws InterruptedException {
		
		List<Integer> list = new ArrayList<>();// new Vector<>();
		
		Runnable r = new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<100;i++) {
					list.add(i);
				}
			}
		};
		
		Thread t = new Thread(r);
		Thread t2 = new Thread(r);
		t.start();
		t2.start();
		t.join();
		t2.join();
		System.out.println(list.size());
	}
}
