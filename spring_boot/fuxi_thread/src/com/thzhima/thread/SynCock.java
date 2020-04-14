package com.thzhima.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class SynCock {

	private List<Integer> list = new ArrayList<>();
	ReentrantLock lock = new ReentrantLock();
	public  void add(Integer i) {
		
		lock.lock();
//		synchronized (list) {
			System.out.println(Thread.currentThread().getName()+"��ʼ");
//			synchronized (list) {
			lock.lock();
			   this.list.add(i);
			lock.unlock();
//			}
			System.out.println(Thread.currentThread().getName()+"����");
		lock.unlock();
//		}
		
	}
	
	public synchronized long size() {
		return this.list.size();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		
		SynCock sc = new SynCock();
		
		Runnable run = ()->{for(int i=0;i<2000;i++) {
			sc.add(i);
		}};
		
		Thread t = new Thread(run);
		Thread t2 = new Thread(run);
		t.start();
		t2.start();

		t.join(); // ��ǰ�̵߳� t ��  t2 ����֮�� ����ִ�С�
		t2.join();
		
		//==========
		System.out.println(sc.size());
		
	}
}
