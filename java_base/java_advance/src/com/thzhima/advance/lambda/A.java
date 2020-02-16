package com.thzhima.advance.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import com.thzhima.advance.bean.Student;

public class A {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		List<Integer>  li = new ArrayList<>();
		list.parallelStream();
		list.stream().filter((new Predicate<Integer>() {

			@Override
			public boolean test(Integer t) {
				
				return t>5;
			}
		})).forEach((e)->li.add(e));
		
		System.out.println(li); 
		
		//======================================================
		StudentCreator creator = (a,b,c,d)-> new Student(a,b,c,d);//Student::new;
		Student stu = creator.createStudent(20, "wang", "WANG", "123");
		
		System.out.println(stu);
		
		
		Lam lam = stu::study;//()->stu.study();
		lam.todo();
		
	}
}
