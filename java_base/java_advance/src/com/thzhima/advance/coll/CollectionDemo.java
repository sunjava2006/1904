package com.thzhima.advance.coll;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {

	public static void main(String[] args) {
		
		Collection<String> coll = new ArrayList<>();
		Collection<String> coll2 = new ArrayList<>();
		
		coll.add("java");// add方法，向集合中添加元素
		coll.add("c");
		coll.add("c--");
		coll.add("c#");
		System.out.println(coll);//toString()
		for(String s : coll) {
			System.out.println(s);
		}
		
		System.out.println("-------------------");
		coll2.add("java");
		coll2.add("c++");
		coll2.forEach(a->System.out.println(a));
		System.out.println("-------after add coll2 to coll-----------");
		coll.addAll(coll2);
		System.out.println(coll);
		
		coll2.add("python");
		
		// 判断集合中是否包含某一个元素
		System.out.println("coll 包含 java?"+(coll.contains("java")));
		// 判断给定的集合是否是当前集合的真子集。
		System.out.println("coll 包含coll2?"+(coll.containsAll(coll2)));
		Object c = ((ArrayList)coll).clone();
		
		// 比较集合中所有元素是否一样
		System.out.println("coll equals c?"+coll.equals(c));
		
		System.out.println("hashCode:"+coll.hashCode());
		
		// 判断当前集合是否是空的。
		System.out.println("isEmpty?"+coll.isEmpty());
		
		// Collection继承的Iterable接口方法
		Iterator<String> iter = coll.iterator();
		while(iter.hasNext()) {
			String e = iter.next();
			System.out.println("元素是："+e);
		}
		
		// 集合的大小
		System.out.println("集合大小为："+coll.size());
		
		// 删除一个元素
		coll.remove("c");
		System.out.println("删除C后，大小为："+coll.size());
		
		// 从当前集合中删除参数中包含的元素
		coll.removeAll(coll2);
		System.out.println(coll);
		
		((Collection)c).retainAll(coll2);
		System.out.println(c);
		
		Object[] array = coll.toArray();
		String[] a = coll.toArray(new String[coll.size()]);
		//清除元素clear()
		coll.clear();
		System.out.println(coll.isEmpty());
		System.out.println(coll.size());
		
	}
	
}
