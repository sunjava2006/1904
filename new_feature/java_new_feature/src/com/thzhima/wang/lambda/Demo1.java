package com.thzhima.wang.lambda;

public class Demo1 {

	public static void main(String[] args) {
		
		
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName());
				
			}
		});
		
		t.start();
		
		// ������
//		Runnable runnable = new Runnable() {
//			@Override
//			public void run() {
//				System.out.println(Thread.currentThread().getName());
//			}
//		};
		
		//// ʹ��Lambda���ʽ,��������������������ȥʵ��һ���ӿڡ�
		Runnable runnable = () -> {System.out.println(Thread.currentThread().getName());};
		
		Thread t2 = new Thread(runnable);
		t2.start();
		
		
		Flyable fly = () -> System.out.println("hello");
		
		
	}
}
