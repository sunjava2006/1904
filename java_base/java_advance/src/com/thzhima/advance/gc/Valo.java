package com.thzhima.advance.gc;

public class Valo {

	public volatile static boolean flag = false;
	
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread() {
			public void run() {
				System.out.println("wait data.....");
				while(!Valo.flag) {
					
				}
				System.out.println("end......");
			}
		};
		
		Thread t2 = new Thread() {
			public void run() {
				System.out.println("prepared data....");
				Valo.flag = true;
				System.out.println("update data success....");
			}
		};
		
		t.start();
		
		Thread.sleep(2000);
		
		t2.start();
		
		
	}
}
