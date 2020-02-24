package com.wangrui.myadvance;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws InterruptedException  {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(3 ,()->System.out.println("--------------------------"));

		for(int j=0;j<=3;j++) {
			for (int i = 0; i < 3; i++) {
				Thread t = new Thread() {
					public void run() {
						try {
							System.out.println(Thread.currentThread().getName()+" run");
							cyclicBarrier.await();
						
							System.out.println(Thread.currentThread().getName()+" end");
						} catch (InterruptedException | BrokenBarrierException e) {
							e.printStackTrace();
						}
						
					}
				};

				
				t.start();
				Thread.sleep(1000);
			}
		    
		}
		
			
		

	}
}
