package com.wangrui.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Pool {

	public static void main(String[] args) {
//		ExecutorService pool = Executors.newFixedThreadPool(4);
		
		ThreadPoolExecutor poolA = new ThreadPoolExecutor(4, 4, // 池是最小线程数， 池中最大线程数
                0L, TimeUnit.MILLISECONDS,  // 在多长时间内可以让空闲的线程存在，而不杀死这个线程。毫秒
                new LinkedBlockingQueue<Runnable>()); // 阻塞队列（有界队列，有大小限制|无界队列，没有大小限制）
		
		ThreadPoolExecutor poolB = new ThreadPoolExecutor(1, 4, // 池是最小线程数， 池中最大线程数
                0L, TimeUnit.MILLISECONDS,  // 在多长时间内可以让空闲的线程存在，而不杀死这个线程。毫秒
                new ArrayBlockingQueue<>(4));  // 有界4个大。
		
		
		ThreadPoolExecutor poolC = new ThreadPoolExecutor(1, 4, // 池是最小线程数， 池中最大线程数
                0L, TimeUnit.MILLISECONDS,  // 在多长时间内可以让空闲的线程存在，而不杀死这个线程。毫秒
                new SynchronousQueue<>());  // 同步队列。没有空间。
		
		for(int i=0; i<10; i++) {
			Runnable run = ()->{
				System.out.println("开始："+Thread.currentThread().getId());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("结束："+Thread.currentThread().getId());
			};
			
			poolB.execute(run);
		}
		System.out.println("end for..........");
	
	}

}
