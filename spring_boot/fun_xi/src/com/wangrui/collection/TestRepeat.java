package com.wangrui.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class TestRepeat {

	public static void main(String[] args) {
		List<Integer> li = new ArrayList<>();
		li.add(1);
		li.add(2);
//		System.out.println(li.size());
		
		li.forEach(System.out::println);// List本身的遍历方法
		li.stream().forEach((i)->System.out.println(i)); // List转化为Stream，用的是Stream的遍历方法。
		for(Integer i : li) {   // Iterable接口
			System.out.println(i);
		}
		for(int i=0; i<li.size(); i++) { // 通过List大小遍历
			System.out.println(li.get(i));// 获取指定下标的元素
		}
		Iterator<Integer> ite = li.iterator();
		while(ite.hasNext()) { // 通过迭代器
			Integer i = ite.next();
			System.out.println(i);
		}
		System.out.println("-------------------------------------------");
		
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		q.offer(2);
//		System.out.println(q.size());
		q.forEach(System.out::println);
		q.stream().forEach(System.out::println);
		for(Integer i : q) {
			System.out.println(i);
		}
		while(!q.isEmpty()) {
			Integer e = q.poll();
			System.out.println(e);
		}
		System.out.println(q.size());
		
		System.out.println("=========================================");
		
		Set<Integer> s = new HashSet<>();
		s.add(2);
		s.add(1);
//		System.out.println(s.size());
		s.forEach(System.out::println);
		
		System.out.println("##########################################");
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(4);
		stack.push(1);
		System.out.println(stack);
		stack.forEach(System.out::println);
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
		
	}
}
