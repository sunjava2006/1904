package com.thzhima.advance.coll;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class ListDemo {

	public static void main(String[] args) {
		
		List<String> list = new Vector<>();
		list = new ArrayList<>();
		
		System.out.println(list.size());
		list.add("java");
		list.add("c");
		System.out.println(list.toString()+list.size());
		list.add(2, "c++");
		System.out.println(list);
		
		System.out.println(list.indexOf("c"));
		System.out.println(list.get(0));
		
		// 通过size，遍历List
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
		// List 返回单向迭代器
		Iterator<String> ite = list.iterator();
		while(ite.hasNext()) {
			System.out.println(ite.next());
		}
		System.out.println("=====================");
		// List 返回双向迭代器
		ListIterator<String> listIte = list.listIterator(1);
		while(listIte.hasNext()) {
			System.out.println(listIte.next());
		}
		System.out.println("---------------------");
		while(listIte.hasPrevious()) {
			System.out.println(listIte.previous());
		}
		
		list.set(1, "c#");
		System.out.println(list);
		
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%");
		
		List<String> sub = list.subList(1, 3);
		System.out.println(sub);
		list.addAll(sub);
//		sub.remove(0);
		
	}
}
