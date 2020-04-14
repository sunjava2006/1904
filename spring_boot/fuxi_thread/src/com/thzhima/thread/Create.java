package com.thzhima.thread;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Create {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		
		// 继承Thread类，重写run方法。
		Thread t = new Thread() {
			public void run() {
				System.out.println("hello");
			}
		};
		t.start();
		
		// 实现Runnable接口，传入Thread
		Runnable run = ()->System.out.println(Thread.currentThread().getName());
		Thread t2 = new Thread(run);
		t2.start();
		
		// 实现Callable接口
		Callable<String> call = ()->"china";
		ExecutorService es = Executors.newSingleThreadExecutor();
		Future<String> f = es.submit(call);
		System.out.println(f.get());
		es.shutdown();
		
	
		
		// TimerTask
		TimerTask task = new TimerTask() {
			@Override
			public void run() {
				System.out.println("-----------------");
				
			}
		};
		Timer timer = new Timer();
		timer.schedule(task, new Date(System.currentTimeMillis()+2000));
		
		

	}

}
