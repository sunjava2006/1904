package com.thzhima.advance.gen;

import java.util.ArrayList;
import java.util.List;

import com.thzhima.advance.bean.Student;

public class Test2 {
	public static void main(String[] args) {
		Home h = new Home();
		h.setPet(new Dog());
		
		Object o = h.getPet();
		if(o instanceof Dog) {
			Dog d = (Dog)o;
			d.bark();
		}else if(o instanceof Cat) {
			Cat c = (Cat)o;
			c.bark();
		}
		
		List list = new ArrayList();
		list.add(new Student());
		list.add("china");
		
		Object o1 = list.get(0);
		Student s = (Student)o1;
		System.out.println(s.getName());
		Object o2 = list.get(1);
		String ss = (String)o2;
		System.out.println(ss.toUpperCase());
		
		List<Student> li = new ArrayList<>();
		li.add(new Student());
		Student stu = li.get(0);
	
		
	}
}
