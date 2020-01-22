package com.thzhima.advance.gen;

public class Test {

	public static void main(String[] args) {
		Home<Dog> home = new Home<>();
		home.setPet(new Dog());
		Dog dog = home.getPet();
		dog.bark();
		
		Home<Cat> home2 = new Home<>();
		home2.setPet(new Cat());
		Cat cat = home2.getPet();
		cat.bark();
	}
}
