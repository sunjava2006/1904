package com.thzm.advance.lmb;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test {
	public static void main(String[] args) {
		
		StringTool tool = String::substring; // 接口中第一个参数，作为类的实例来用。后面的参数是方法参数。
		String s = tool.subStr("china", 0, 2);
		System.out.println(s);
		
		
		List list = new ArrayList();
		
		list.removeIf(new Predicate<T>() {
		})
	}
}