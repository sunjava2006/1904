package com.wangrui.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MatchDemo {

	public static void main(String[] args) {
		List<People> list =Arrays.asList(new People("Jack", "Male", 20),
										new People("Jack", "Male", 20),
						                new People("Peger", "Male", 22),
						                new People("Jhon", "Male", 25),
						                new People("Marry", "Female", 19),
						                new People("Rose", "Female", 20),
						                new People("Hellon", "Female", 20));
		
		
		// AllMatch,筛选出年龄大于20的元素。判断是否都大于20。
		boolean gt20 = list.stream().filter(i->i.getAge()>20).allMatch((t)-> t.getAge()>20);
		System.out.println(gt20);
		
		// anyMatch,判断流中大于19岁的，是否有女生。
		boolean femaleHave = list.stream().filter(i->i.getAge()>19)
				.anyMatch(i->"Female".equals(i.getGender()));
		System.out.println(femaleHave);
		
		// 没有一个年龄是30的。
		boolean age30 = list.stream().noneMatch(i->i.getAge()==30);
		System.out.println(age30);
		
		// 获取第一个年龄是20的元素
		Optional<People> op = list.stream().filter(i->i.getAge()==20).findFirst();
		System.out.println(op.isPresent() ? op.get() : "没找到");
		
		
		// 获取任一个年龄是20的元素
		Optional<People> opt = list.stream().filter(i->i.getAge()==20).findFirst();
		System.out.println(opt.isPresent() ? op.get() : "没找到");
		
		// 获取年龄是20的人的数量
		long count = list.stream().filter(i->i.getAge()==20).count();
		System.out.println(count);
		
		// 找出年龄最大的人
		Optional<People> maxAgePeople = list.stream().max((a,b)->a.getAge()-b.getAge());
		System.out.println(maxAgePeople);
		
		// 找出年龄最小的人
		Optional<People> minAgePeople = list.stream().min((a,b)->a.getAge()-b.getAge());
		System.out.println(minAgePeople);
		
	}
}
