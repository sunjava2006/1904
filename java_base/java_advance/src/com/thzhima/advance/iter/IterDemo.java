package com.thzhima.advance.iter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IterDemo {
	public static void main(String[] args) {
	
		List<String> list = new ArrayList<>();
		list.add("java");
		list.add("c");
		list.add("c++");
		list.add("c#");
		
		// 获取迭代器。
		Iterator<String> iter = list.iterator();
		
		// 显示操作迭代器
		while(iter.hasNext()) {//判断迭代器中是否有下一个元素
			String s = iter.next(); //取迭代器中下一个元素
			System.out.println(s);
		}
		
		// 隐式迭代,for...each循环，只能用在数组和迭代器接口上。
		for(String s : list) {
			System.out.println(s);
		}
		
		
		
	}
}
