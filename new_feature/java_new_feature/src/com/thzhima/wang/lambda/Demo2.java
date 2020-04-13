package com.thzhima.wang.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.function.Consumer;

public class Demo2 {

	public static void main(String[] args) {
		// �в�����û����ֵ
		List<String> list = Arrays.asList("java", "js", "c", "c++", "vb");
		
		Consumer<String> consumer = t -> System.out.println(t);
		list.forEach(consumer);
		
		
		// �в������з���ֵ
		Comparator<Integer> comparator = (a, b) ->  b-a;
		SortedSet<Integer> set = new TreeSet<>(comparator);
		set.add(20);
		set.add(50);
		set.add(1);
		set.add(5);
		set.forEach((Integer i)->System.out.println(i));
	}
}
