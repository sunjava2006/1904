package com.thzhima.thread;

public class Synchro {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(()-> {
			for(int i=0;i<10;i++) {
				System.out.println("------------------");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("==================");
			}
			
		});
		t.sleep(10000);
		
		t.start();
		
	}
}
