package com.thzhima.wang.lambda;

@FunctionalInterface
public interface Flyable {

	void fly();
	
    default void a() {
    	System.out.println("---------");
    }
}
