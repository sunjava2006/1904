package com.thzhima.base;

public class StringBufferMethod {

	public static void main(String[] args) {
		String s = new String("china");// 2¸ö×Ö·û´®¶ÔÏó
		
		//StringBuffer sb = new StringBuffer(16);
		StringBuilder sb = new StringBuilder();
		sb.append("my");
		sb.append(" age ");
		sb.append(20);
		sb.append(false);
		
		sb.insert(9, " ");
		sb.delete(9, 15);
		int idx = sb.indexOf("age");
		System.out.println(idx==-1?false:true);
		
		String str = sb.toString();
		System.out.println(str);
		char c= sb.charAt(0);
		String ss = String.valueOf(c);
		ss = ss.toUpperCase();
		System.out.println(sb.replace(0, 1, ss));
		System.out.println(sb.reverse());
		System.out.println(sb);
	}
}
