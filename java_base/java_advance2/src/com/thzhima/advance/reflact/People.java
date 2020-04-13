package com.thzhima.advance.reflact;

@Deprecated
public class People {

	public String name;
	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public People() {
		System.out.println("People()");
	}
	
	public People(String name, int age) {
		System.out.println("People(name, age)");
		this.name = name;
		this.age = age;
	}
	
    @MyMessage
	public void work() {
		System.out.println(this.name + " working now.");
	}
	
	public String work(String task) {
		System.out.println(this.name + " working yet.");
		return "end "+task;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + "]";
	}
	
	
	
}
