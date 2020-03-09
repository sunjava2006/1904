package com.thzm.advance.lmb;

public class People {
	 String name;
	 
     public People(String name) {
    	 this.name = name;
     }
     
     public People() {
    	 
     }
     
     public static void main(String[] args) {
		Todo todo = People::new;
		todo.getPeople("Wang");
	}
}

interface Todo{
	People getPeople(String name);
}
