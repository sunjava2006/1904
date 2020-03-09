package com.thzm.advance.lmb;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class LamRef {

	public void printThread() {
	    System.out.println(Thread.currentThread().getName());	
	}
	
	public static void main(String[] args) {
		
		LamRef lr = new LamRef();
		Runnable run = lr::printThread; // 引用实例方法 
		Thread t = new Thread(run);
		t.start();
	
		Comparator<Integer> comparator = Integer::compare;// 引用静态方法 
		SortedSet<Integer> set = new TreeSet<>(comparator);
		
	}
	
}
