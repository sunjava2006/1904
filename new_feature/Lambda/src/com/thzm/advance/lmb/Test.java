package com.thzm.advance.lmb;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Test {
	public static void main(String[] args) {
		
		StringTool tool = String::substring; // �ӿ��е�һ����������Ϊ���ʵ�����á�����Ĳ����Ƿ���������
		String s = tool.subStr("china", 0, 2);
		System.out.println(s);
		
		
		List list = new ArrayList();
		
		list.removeIf(new Predicate<T>() {
		})
	}
}