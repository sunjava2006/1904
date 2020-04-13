package com.wangrui.lambda;

public class TEst2 {

	public static void main(String[] args) {
		
	   S s = String::new;
	   String msg = s.sss("hello", "dfdf");
	   System.out.println(msg);
		
	}
}
