package com.thzhima.thread;

public class WaitNodify {

	public static void main(String[] args) throws InterruptedException {
		Object o = new Object();
		
		Thread t = new Thread() {
			public void run() {
			   	synchronized (o) {
					try {
						System.out.println("--------will wait------");
						o.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			   	System.out.println("------------end------------");
			}
		};
		
		t.start();
		
		Thread.sleep(2000);
		synchronized (o) {
			System.out.println("will notify");
			o.notifyAll();
		}
		
		
		
		
	}
}
