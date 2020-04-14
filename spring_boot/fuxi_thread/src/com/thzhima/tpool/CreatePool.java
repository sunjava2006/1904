package com.thzhima.tpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class CreatePool {

	public static void main(String[] args) {
		Runnable run = ()->{System.out.println(Thread.currentThread().getName());
							try {
								Thread.sleep(1000);
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							System.out.println("------------------------");
		};
		
//		ExecutorService ex = Executors.newSingleThreadExecutor();
//		ExecutorService ex = Executors.newFixedThreadPool(3);
//		ExecutorService ex = Executors.newCachedThreadPool();
		
		ScheduledExecutorService ex = Executors.newScheduledThreadPool(2);
		
		for(int i=0;i<10;i++) {
			//ex.submit(run);
			ex.schedule(run, 1, TimeUnit.SECONDS);
		}
		
		
		
		
		
		//ex.shutdown();// ¹Ø±ÕÏß³Ì³Ø
		
		
	}
}
