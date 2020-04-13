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
		
		// 匿名类
//		Runnable runnable = new Runnable() {
//			@Override
//			public void run() {
//				System.out.println(Thread.currentThread().getName());
//			}
//		};
		
		//// 使用Lambda表达式,匿名函数。用匿名函数去实现一个接口。
		Runnable runnable = () -> {System.out.println(Thread.currentThread().getName());};
		
		Thread t2 = new Thread(runnable);
		t2.start();
		
		
		Flyable fly = () -> System.out.println("hello");
		
		
	}
}
