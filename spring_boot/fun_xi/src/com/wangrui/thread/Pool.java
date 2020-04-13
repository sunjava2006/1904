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
		
		ThreadPoolExecutor poolA = new ThreadPoolExecutor(4, 4, // ������С�߳����� ��������߳���
                0L, TimeUnit.MILLISECONDS,  // �ڶ೤ʱ���ڿ����ÿ��е��̴߳��ڣ�����ɱ������̡߳�����
                new LinkedBlockingQueue<Runnable>()); // �������У��н���У��д�С����|�޽���У�û�д�С���ƣ�
		
		ThreadPoolExecutor poolB = new ThreadPoolExecutor(1, 4, // ������С�߳����� ��������߳���
                0L, TimeUnit.MILLISECONDS,  // �ڶ೤ʱ���ڿ����ÿ��е��̴߳��ڣ�����ɱ������̡߳�����
                new ArrayBlockingQueue<>(4));  // �н�4����
		
		
		ThreadPoolExecutor poolC = new ThreadPoolExecutor(1, 4, // ������С�߳����� ��������߳���
                0L, TimeUnit.MILLISECONDS,  // �ڶ೤ʱ���ڿ����ÿ��е��̴߳��ڣ�����ɱ������̡߳�����
                new SynchronousQueue<>());  // ͬ�����С�û�пռ䡣
		
		for(int i=0; i<10; i++) {
			Runnable run = ()->{
				System.out.println("��ʼ��"+Thread.currentThread().getId());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("������"+Thread.currentThread().getId());
			};
			
			poolB.execute(run);
		}
		System.out.println("end for..........");
	
	}

}
