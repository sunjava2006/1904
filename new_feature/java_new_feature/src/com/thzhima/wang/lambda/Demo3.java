package com.thzhima.wang.lambda;

public class Demo3 {

	public static void main(String[] args) {
		Thread t = new Thread(()->{
			                       try {
			                    	   for(int i=0;i<10;i++) {
					                          System.out.println(i);
					                          Thread.sleep(1000);
					                       }
									} catch (Exception e) {
										e.printStackTrace();
									}
			                       
			                        
		                          });
		t.start();
	}
}
